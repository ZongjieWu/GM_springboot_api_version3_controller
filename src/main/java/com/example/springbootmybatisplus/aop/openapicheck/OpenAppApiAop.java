package com.example.springbootmybatisplus.aop.openapicheck;

import com.example.springbootmybatisplus.enums.Result;
import com.example.springbootmybatisplus.model.SaasUser;
import com.example.springbootmybatisplus.service.ISaasUserPermissionListService;
import com.example.springbootmybatisplus.service.ISaasUserService;
import com.example.springbootmybatisplus.util.JWTUtils;
import com.example.springbootmybatisplus.util.MD5Util;
import com.example.springbootmybatisplus.util.RedisUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.*;

/**
 * @author wzj
 * @date 2019-07-03 16:18
 */
@Component
@Aspect
public class OpenAppApiAop {

    private static final Long apiAppRequestTime=120000L;
    private static final Long apiAppNonceTime=300000L;
    @Autowired
    private ThreadPoolTaskExecutor threeTaskExecutor;
    @Autowired
    private ISaasUserService saasUserService;
    @Autowired
    private RedisUtil redisUtil;

    /**
     * 拦截所有有关权限的请求
     * 传入部门id 通过当前用户id 去查看所有权限如果发现没对应的权限则返回
     */
    @Around(value = "execution (* com.example.springbootmybatisplus.web.controller.openapi.app.*.*(..)) && @annotation(com.example.springbootmybatisplus.aop.openapicheck.OpenAppApiCheck)")
    @Order(2)
    public Object getFunctionTreeInfoVoAop(ProceedingJoinPoint pjp) throws Throwable {
        //拦截方法
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        Type type = method.getAnnotatedReturnType().getType();
        OpenAppApiCheck lock = method.getAnnotation(OpenAppApiCheck.class);
        if (lock == null) {
            return pjp.proceed();
        }
//        得到注解上的参数
//        String socketvalue = lock.value();

        //使用环绕增强
        //获取request对象
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();



        String jwt=request.getHeader("token");
        if (null==jwt||"".equals(jwt)) {
            return Result.retrunFailMsg("请先登录!!!");
        }

        //token自定义时用
//        UserTokenDto userTokenDto = null;
//        try {
//            userTokenDto=TokenUtil.get(request);
//        }catch (Exception e){
//            return Result.retrunFailMsg("token错误");
//        }
//        if (userTokenDto == null) {
//            return Result.retrunFailMsg("登录授权早已失效,请重新登录");
//        }
//        //当前用户ID
//        Long currentUserId = userTokenDto.getId();
//        if (currentUserId == null) {
//            return Result.retrunFailMsg("请联系管理员获取账号!!!");
//        }

        Claims c=null;
        try {
            c= JWTUtils.parseJWT(jwt);
        }catch (ExpiredJwtException e){
            return Result.retrunFailMsg("登入超时,请重新登入");
        }


        //验证时间
        if(System.currentTimeMillis()<=Long.valueOf(c.get("exp").toString())){
            System.out.println("请求超时哦！");
            return Result.retrunFailMsg("登入超时,请重新登入");
        }

        //验证身份
        if(c.get("loginId")==null){
            return Result.retrunFailMsg("请联系管理员获取账号1!!!");
        }

        SaasUser saasUser=saasUserService.getById(Long.valueOf(c.get("loginId").toString()));
        //用户不存在
        if(saasUser==null){
            return Result.retrunFailMsg("请联系管理员获取账号2!!!");
        }


        //获取请求参数
        Map<String,String[]> paramMap=request.getParameterMap();
        List<String> param= new ArrayList<>(paramMap.keySet());
        param.remove("sign");
        param.remove("timestamp");
        param.remove("nonce");
        param.sort((o1,o2)-> o1.compareToIgnoreCase(o2));
        StringBuffer sbr=new StringBuffer();
        param.forEach((s)->{
            sbr.append(s+"="+paramMap.get(s)[0]+"&");
        });


        if(paramMap.get("sign")[0]==null){
            return Result.retrunFailMsg("签名不能为空");
        }
        if(paramMap.get("timestamp")==null){
            return Result.retrunFailMsg("时间戳不能为空");
        }

        if(paramMap.get("nonce")==null){
            return Result.retrunFailMsg("随机字符串不能为空");
        }


        String timestamp=paramMap.get("timestamp")[0];
        String nonce=paramMap.get("nonce")[0];
        sbr.append("timestamp="+timestamp+"&");
        sbr.append("nonce="+nonce+"&");
        String clientSign=paramMap.get("sign")[0];


        String serverSign= MD5Util.getMD5(sbr.append("appKey="+saasUser.getAppKey()).toString());

        if(!clientSign.equals(serverSign)){
            return Result.retrunFailMsg("签名不匹配");
        }



        Long diffSecond=Math.abs(Long.valueOf(timestamp)-System.currentTimeMillis());
        if(diffSecond>apiAppRequestTime){
            return Result.retrunFailMsg("请求过时");
        }


        String serverNonce= redisUtil.get("apiAppNonce_"+nonce);
        if(serverNonce==null){
            redisUtil.set("apiAppNonce_"+nonce,nonce,apiAppNonceTime);
        }else{
            redisUtil.set("apiAppNonce_"+nonce,nonce,apiAppNonceTime);
            return Result.retrunFailMsg("请求重复");
        }




        //去查看用户对应的权限
//        Map<String,Boolean> permissionMap = permissionListService.getSaasUserPermission(currentUserId);
//        if (permissionMap.get(Is.trim(socketvalue)) != null) {
//            // 使用子线程去记录操作日志
//            // 通过接口的注解去判断操作类型
//            Integer operType = 0;
//            if (method.getAnnotation(GetMapping.class) != null) {
//                operType = 1;
//            } else if (method.getAnnotation(PostMapping.class) != null) {
//                operType = 2;
//            } else if (method.getAnnotation(PutMapping.class) != null) {
//                operType = 3;
//            } else if (method.getAnnotation(DeleteMapping.class) != null) {
//                operType = 4;
//            }
//            final Integer ot = operType;
//            // 需要异步执行!!!!!
////                threeTaskExecutor.execute(() -> {
////                    userLogService.insertUserLog(currentUserId, departmentId, ot, map.get(Is.trim(socketvalue)), pjp.getArgs());
////                });
//            // 有权限
//            return pjp.proceed();
//        }
        return pjp.proceed();
//        return Result.retrunFailMsg("权限不足或配置错误");
    }

}

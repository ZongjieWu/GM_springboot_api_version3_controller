package com.example.springbootmybatisplus.aop.role;

import com.example.springbootmybatisplus.enums.Result;
import com.example.springbootmybatisplus.model.SaasUser;
import com.example.springbootmybatisplus.service.ISaasUserPermissionListService;
import com.example.springbootmybatisplus.service.ISaasUserService;
import com.example.springbootmybatisplus.util.JWTUtils;
import com.example.springbootmybatisplus.util.Token.Is;
import com.example.springbootmybatisplus.util.Token.TokenUtil;
import com.example.springbootmybatisplus.util.Token.UserTokenDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import org.apache.ibatis.annotations.Param;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * @author wzj
 * @date 2019-07-03 16:18
 */
@Component
@Aspect
public class SocketRoleAop {

    @Autowired
    private ThreadPoolTaskExecutor threeTaskExecutor;
    @Autowired
    private ISaasUserPermissionListService permissionListService;
    @Autowired
    private ISaasUserService saasUserService;

    /**
     * 拦截所有有关权限的请求
     * 传入部门id 通过当前用户id 去查看所有权限如果发现没对应的权限则返回
     */
    @Around(value = "execution (* com.example.springbootmybatisplus.web.controller..*.*(..)) && @annotation(SocketRole)")
    @Order(2)
    public Object getFunctionTreeInfoVoAop(ProceedingJoinPoint pjp) throws Throwable {
        //拦截方法
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        Type type = method.getAnnotatedReturnType().getType();
        SocketRole lock = method.getAnnotation(SocketRole.class);
        if (lock == null) {
            return pjp.proceed();
        }
//        得到注解上的参数
        String socketvalue = lock.value();

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

        //验证身份
        if(c.get("loginId")==null){
            return Result.retrunFailMsg("请联系管理员获取账号1!!!");
        }else
        {
            SaasUser saasUser=saasUserService.getById(Long.valueOf(c.get("loginId").toString()));
            if(saasUser==null){
                return Result.retrunFailMsg("请联系管理员获取账号2!!!");
            }
        }

        //验证时间
        if(System.currentTimeMillis()<=Long.valueOf(c.get("exp").toString())){
            System.out.println("请求超时哦！");
            return Result.retrunFailMsg("登入超时,请重新登入");
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

package com.example.springbootmybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootmybatisplus.enums.Result;
import com.example.springbootmybatisplus.mapper.SaasUserMapper;
import com.example.springbootmybatisplus.mapper.SaasUserPermissionListMapper;
import com.example.springbootmybatisplus.model.SaasUser;
import com.example.springbootmybatisplus.model.SaasUserPermissionList;
import com.example.springbootmybatisplus.model.vo.request.saasuser.user.SaasUserLoginRequestVo;
import com.example.springbootmybatisplus.model.vo.response.SaasUserBaseInfoResponseVo;
import com.example.springbootmybatisplus.service.ISaasUserLoginService;
import com.example.springbootmybatisplus.util.AESUtil;
import com.example.springbootmybatisplus.util.BeanCopyTools;
import com.example.springbootmybatisplus.util.JWTUtils;
import com.example.springbootmybatisplus.util.MD5Util;
import com.example.springbootmybatisplus.util.Token.TokenUtil;
import com.example.springbootmybatisplus.util.Token.UserTokenDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ZongjieWu
 * @since 2020-04-19
 */
@Service
public class SaasUserLoginiServiceImpl extends ServiceImpl<SaasUserMapper, SaasUser> implements ISaasUserLoginService {
    public static final String AES_KEY = "t89zsda45fdf4wa5";
    @Autowired
    private SaasUserMapper saasUserMapper;
    @Autowired
    private SaasUserPermissionListMapper saasUserPermissionListMapper;

    @Override
    public Result<SaasUserBaseInfoResponseVo> login(SaasUserLoginRequestVo saasUserLoginRequestVo) {
        //查询包装器
        QueryWrapper<SaasUser> queryWrapper = new QueryWrapper<SaasUser>();
        queryWrapper.lambda().eq(SaasUser::getPhone, saasUserLoginRequestVo.getPhone());
        SaasUser userSaasRes=saasUserMapper.selectOne(queryWrapper);
        if(userSaasRes==null){
            return Result.retrunFailMsg("此用户不存在");
        }
        if(!MD5Util.getMD5(AESUtil.encode(saasUserLoginRequestVo.getPwd(), AES_KEY)).equals(userSaasRes.getPwd())){
            return Result.retrunFailMsg("密码错误");
        }

        //查询菜单
        QueryWrapper<SaasUserPermissionList> queryPermissionWrapper = new QueryWrapper<SaasUserPermissionList>();
        queryPermissionWrapper.lambda().eq(SaasUserPermissionList::getParentId,0);
        queryPermissionWrapper.orderByAsc("sort");
        List<SaasUserPermissionList> saasUserPermissionListList=saasUserPermissionListMapper.selectList(queryPermissionWrapper);
        saasUserPermissionListList.forEach(item->{
            QueryWrapper<SaasUserPermissionList> queryPermission2Wrapper = new QueryWrapper<SaasUserPermissionList>();
            queryPermission2Wrapper = new QueryWrapper<SaasUserPermissionList>();
            queryPermission2Wrapper.lambda().eq(SaasUserPermissionList::getParentId,item.getId());
            queryPermission2Wrapper.orderByAsc("sort");
            item.setSaasUserPermissionList(saasUserPermissionListMapper.selectList(queryPermission2Wrapper));
        });


        SaasUserBaseInfoResponseVo userSaasBaseInfoVo= BeanCopyTools.copy(userSaasRes,SaasUserBaseInfoResponseVo.class);



        //        自定义token
        //        String token = TokenUtil.createToken(new UserTokenDto(userSaasRes.getId(),2,0L));
        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("loginId", userSaasRes.getId());
        //86400000是过期时间  24小时
        String jwt=null;
        try {
           jwt = JWTUtils.createJWT("jwt", userSaasRes.getPhone(), 900000,payload);
        } catch (Exception e) {
            e.printStackTrace();
        }

        userSaasBaseInfoVo.setToken(jwt);
        userSaasBaseInfoVo.setSaasUserPermissionList(saasUserPermissionListList);
        return Result.retrunSucessMsgData(userSaasBaseInfoVo);
    }
}

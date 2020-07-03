package com.example.springbootmybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springbootmybatisplus.enums.Result;
import com.example.springbootmybatisplus.model.SaasUser;
import com.example.springbootmybatisplus.model.vo.request.saasuser.user.SaasUserLoginRequestVo;
import com.example.springbootmybatisplus.model.vo.response.SaasUserBaseInfoResponseVo;

public interface ISaasUserLoginService  extends IService<SaasUser> {
    Result<SaasUserBaseInfoResponseVo> login(SaasUserLoginRequestVo saasUserLoginRequestVo);
}

package com.example.springbootmybatisplus.service;

import com.example.springbootmybatisplus.enums.Result;
import com.example.springbootmybatisplus.model.SaasUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springbootmybatisplus.model.vo.request.saasuser.user.SaasUserPagingRequestVo;
import com.example.springbootmybatisplus.model.vo.response.SaasUserBaseInfoResponseVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ZongjieWu
 * @since 2020-04-19
 */
public interface ISaasUserService extends IService<SaasUser> {
    Result<List<SaasUserBaseInfoResponseVo>> paging(Integer page,Integer limit,SaasUserPagingRequestVo saasUserPagingRequestVo);
}

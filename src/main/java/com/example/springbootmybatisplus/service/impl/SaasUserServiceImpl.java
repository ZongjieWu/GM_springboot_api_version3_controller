package com.example.springbootmybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springbootmybatisplus.enums.Result;
import com.example.springbootmybatisplus.model.SaasUser;
import com.example.springbootmybatisplus.mapper.SaasUserMapper;
import com.example.springbootmybatisplus.model.vo.request.saasuser.user.SaasUserPagingRequestVo;
import com.example.springbootmybatisplus.model.vo.response.SaasUserBaseInfoResponseVo;
import com.example.springbootmybatisplus.service.ISaasUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootmybatisplus.util.BeanCopyTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ZongjieWu
 * @since 2020-04-19
 */
@Service
public class SaasUserServiceImpl extends ServiceImpl<SaasUserMapper, SaasUser> implements ISaasUserService {
    @Autowired
    private SaasUserMapper saasUserMapper;
//    @Override
//    public Result<List<SaasUserBaseInfoResponseVo>> paging(Integer page, Integer limit, SaasUserPagingRequestVo saasUserPagingRequestVo) {
//        IPage<SaasUser> userPage = new Page<>(page, limit);//参数一是当前页，参数二是每页个数
//        //组装查询器
//        QueryWrapper<SaasUser> saasUserQueryWrapper=new QueryWrapper<SaasUser>();
//        saasUserQueryWrapper.lambda()
//                .like(!StringUtils.isEmpty(saasUserPagingRequestVo.getKeywords()),SaasUser::getPhone,saasUserPagingRequestVo.getKeywords())
//                .or().like(!StringUtils.isEmpty(saasUserPagingRequestVo.getKeywords()),SaasUser::getName,saasUserPagingRequestVo.getKeywords());
//
//        userPage = saasUserMapper.selectPage(userPage, saasUserQueryWrapper);
//        List<SaasUser> saasUserList=userPage.getRecords();
//        List<SaasUserBaseInfoResponseVo> saasUserBaseInfoResponseVoLis=new ArrayList<>();
//        BeanCopyTools.copy(saasUserList,saasUserBaseInfoResponseVoLis,SaasUserBaseInfoResponseVo.class);
//        Result<List<SaasUserBaseInfoResponseVo>> result=Result.retrunSucessMsgData(saasUserBaseInfoResponseVoLis);
//        result.setCount(userPage.getTotal());
//        return result;
//    }

    @Override
    public Result<List<SaasUserBaseInfoResponseVo>> paging(Integer page, Integer limit, SaasUserPagingRequestVo saasUserPagingRequestVo) {
        Page<SaasUser> userPage = new Page<SaasUser>(page, limit);//参数一是当前页，参数二是每页个数
        //组装查询器
        IPage<SaasUser> iPage = saasUserMapper.paging(userPage, saasUserPagingRequestVo);
        List<SaasUser> saasUserList=iPage.getRecords();
        List<SaasUserBaseInfoResponseVo> saasUserBaseInfoResponseVoLis=new ArrayList<>();
        BeanCopyTools.copy(saasUserList,saasUserBaseInfoResponseVoLis,SaasUserBaseInfoResponseVo.class);
        Result<List<SaasUserBaseInfoResponseVo>> result=Result.retrunSucessMsgData(saasUserBaseInfoResponseVoLis);
        result.setCount(iPage.getTotal());
        return result;
    }
}

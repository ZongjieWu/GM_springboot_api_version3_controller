package com.example.springbootmybatisplus.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springbootmybatisplus.model.SaasUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootmybatisplus.model.vo.request.saasuser.user.SaasUserPagingRequestVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ZongjieWu
 * @since 2020-04-19
 */
@Repository
public interface SaasUserMapper extends BaseMapper<SaasUser> {
    IPage<SaasUser> paging(Page<SaasUser> page, @Param("saasUserPagingRequestVo") SaasUserPagingRequestVo saasUserPagingRequestVo);
}

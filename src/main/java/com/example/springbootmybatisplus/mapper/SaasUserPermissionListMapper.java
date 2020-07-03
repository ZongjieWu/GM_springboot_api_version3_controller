package com.example.springbootmybatisplus.mapper;

import com.example.springbootmybatisplus.model.SaasUserPermissionList;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ZongjieWu
 * @since 2020-04-20
 */
@Repository
public interface SaasUserPermissionListMapper extends BaseMapper<SaasUserPermissionList> {
    List<String> getSaasUserPermission(Long saasUserId);
}

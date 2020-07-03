package com.example.springbootmybatisplus.service;

import com.example.springbootmybatisplus.model.SaasUserRolePermission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ZongjieWu
 * @since 2020-04-20
 */
public interface ISaasUserRolePermissionService extends IService<SaasUserRolePermission> {
    List<Long> listByRoleId(Long saasUserRoleId);
}

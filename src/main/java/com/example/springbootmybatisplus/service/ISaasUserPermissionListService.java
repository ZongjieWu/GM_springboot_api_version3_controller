package com.example.springbootmybatisplus.service;

import com.example.springbootmybatisplus.model.SaasUserPermissionList;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ZongjieWu
 * @since 2020-04-20
 */
public interface ISaasUserPermissionListService extends IService<SaasUserPermissionList> {
    Map<String,Boolean> getSaasUserPermission(Long saasUserId);
}

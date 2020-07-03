package com.example.springbootmybatisplus.service.impl;

import com.example.springbootmybatisplus.model.SaasUserRolePermission;
import com.example.springbootmybatisplus.mapper.SaasUserRolePermissionMapper;
import com.example.springbootmybatisplus.service.ISaasUserRolePermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ZongjieWu
 * @since 2020-04-20
 */
@Service
public class SaasUserRolePermissionServiceImpl extends ServiceImpl<SaasUserRolePermissionMapper, SaasUserRolePermission> implements ISaasUserRolePermissionService {

    @Autowired
    private SaasUserRolePermissionMapper saasUserRolePermissionMapper;
    @Override
    public List<Long> listByRoleId(Long saasUserRoleId) {
        return saasUserRolePermissionMapper.listByRoleId(saasUserRoleId);
    }
}

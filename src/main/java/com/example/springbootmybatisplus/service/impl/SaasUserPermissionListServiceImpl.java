package com.example.springbootmybatisplus.service.impl;

import com.example.springbootmybatisplus.model.SaasUserPermissionList;
import com.example.springbootmybatisplus.mapper.SaasUserPermissionListMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootmybatisplus.service.ISaasUserPermissionListService;
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
 * @since 2020-04-20
 */
@Service
public class SaasUserPermissionListServiceImpl extends ServiceImpl<SaasUserPermissionListMapper, SaasUserPermissionList> implements ISaasUserPermissionListService {

    @Autowired
    private SaasUserPermissionListMapper saasUserPermissionListMapper;
    @Override
    public Map<String,Boolean> getSaasUserPermission(Long saasUserId) {
        List<String> permissionStringList= saasUserPermissionListMapper.getSaasUserPermission(saasUserId);
        Map<String,Boolean> permissonMap=new HashMap<>();
        permissionStringList.forEach(item->{
            permissonMap.put(item,true);
        });
        return permissonMap;
    }
}

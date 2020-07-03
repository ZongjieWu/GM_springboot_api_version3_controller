package com.example.springbootmybatisplus.web.controller;

import com.example.springbootmybatisplus.enums.Result;
import com.example.springbootmybatisplus.model.SaasUserRolePermission;
import com.example.springbootmybatisplus.service.ISaasUserRolePermissionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 *
 * Created by Zongjie Wu on 2020/04/15.
 */
@Api(tags = "4.平台角色权限控制器",description = "登入等接口")
@RestController
@RequestMapping("/saasUserRolePermission/")
public class SaasUserRolePermissionController {

    @Autowired
    private ISaasUserRolePermissionService saasUserRolePermissionService;

    @PostMapping("add")
    public Result add(SaasUserRolePermission saasUserRolePermission) {
        saasUserRolePermission.setAddTime(new Date());
        saasUserRolePermission.setModifyTime(new Date());
        saasUserRolePermissionService.save(saasUserRolePermission);
        return Result.retrunSucess();
    }

    @PostMapping("delete")
    public Result delete(@RequestParam Long id) {
	    saasUserRolePermissionService.removeById(id);
	    return Result.retrunSucess();
    }

    @PostMapping("update")
    public Result update(SaasUserRolePermission saasUserRolePermission) {
        saasUserRolePermission.setModifyTime(new Date());
	    saasUserRolePermissionService.updateById(saasUserRolePermission);
	    return Result.retrunSucess();
    }

    @GetMapping("detail")
    public Result<SaasUserRolePermission> detail(@RequestParam Long id) {
        SaasUserRolePermission saasUserRolePermission = saasUserRolePermissionService.getById(id);
        return Result.retrunSucessMsgData(saasUserRolePermission);
    }

//    @PostMapping("paging")
//    public Result<List<SaasUserRolePermission>> paging(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer limit) {
//        Example example=new Example(SaasUserRolePermission.class);
//        Example.Criteria criteria=example.createCriteria();
//        PageHelper.startPage(page, limit);
//        PageInfo<SaasUserRolePermission> sSaasUserRolePermissionPageInfo = saasUserRolePermissionService.queryPageListByWhereExample(" id desc",page,limit,example);
//        Result<List<SaasUserRolePermission>> result=Result.retrunSucessMsgData(sSaasUserRolePermissionPageInfo.getList());
//        result.setCount(sSaasUserRolePermissionPageInfo.getTotal());
//        return result;
//    }


}

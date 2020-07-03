package com.example.springbootmybatisplus.web.controller;


import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springbootmybatisplus.aop.role.SocketRole;
import com.example.springbootmybatisplus.enums.Result;
import com.example.springbootmybatisplus.model.SaasUserPermissionList;
import com.example.springbootmybatisplus.model.vo.request.saasuser.permission.SaasUserPermissionAddRequestVo;
import com.example.springbootmybatisplus.model.vo.request.saasuser.permission.SaasUserPermissionPagingRequestVo;
import com.example.springbootmybatisplus.model.vo.request.saasuser.permission.SaasUserPermissionUpdateRequestVo;
import com.example.springbootmybatisplus.service.ISaasUserPermissionListService;
import com.example.springbootmybatisplus.service.ISaasUserRolePermissionService;
import com.example.springbootmybatisplus.util.BeanCopyTools;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import springfox.documentation.annotations.ApiIgnore;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ZongjieWu
 * @since 2020-04-20
 */
@Api(tags = "5.平台管理员权限",description = "添加、修改、删除、查询等接口")
@RestController
@RequestMapping("/saasUserPermissionList/")
public class SaasUserPermissionListController {

    @Autowired
    private ISaasUserPermissionListService saasUserPermissionListService;
    @Autowired
    private ISaasUserRolePermissionService saasUserRolePermissionService;

    @SocketRole(value = "add_saasUserPermission")
    @ApiOperation(value = "添加权限",notes = "添加权限")
    @PostMapping("add")
    public Result add(@Validated SaasUserPermissionAddRequestVo saasUserPermissionAddRequestVo) {
        SaasUserPermissionList saasUserPermissionList= BeanCopyTools.copy(saasUserPermissionAddRequestVo,SaasUserPermissionList.class);
        saasUserPermissionList.setAddTime(new Date());
        saasUserPermissionList.setModifyTime(new Date());
        saasUserPermissionListService.save(saasUserPermissionList);
        return Result.retrunSucess();
    }

    @SocketRole(value = "delete_saasUserPermission")
    @ApiOperation(value = "删除权限",notes = "删除权限")
    @ApiImplicitParam(paramType = "query",name = "id",value = "权限表id",required = true,dataType = "int")
    @PostMapping("delete")
    public Result delete(@RequestParam Long id) {
        saasUserPermissionListService.removeById(id);
        return Result.retrunSucess();
    }

    @SocketRole(value = "update_saasUserPermission")
    @ApiOperation(value = "修改权限",notes = "修改权限")
    @PostMapping("update")
    public Result update(@Validated SaasUserPermissionUpdateRequestVo saasUserPermissionUpdateRequestVo) {
        SaasUserPermissionList saasUserPermissionList= BeanCopyTools.copy(saasUserPermissionUpdateRequestVo,SaasUserPermissionList.class);
        saasUserPermissionList.setModifyTime(new Date());
        saasUserPermissionListService.updateById(saasUserPermissionList);
        return Result.retrunSucess();
    }

    @ApiIgnore
    @SocketRole(value = "detail_saasUserPermission")
    @GetMapping("detail")
    public Result<SaasUserPermissionList> detail(@RequestParam Long id) {
        SaasUserPermissionList saasUserPermissionList = saasUserPermissionListService.getById(id);
        return Result.retrunSucessMsgData(saasUserPermissionList);
    }

    //    @OpenAppApiCheck(value = "pageing_saasUserPermission")
    @ApiOperation(value = "分页查询管理员权限",notes = "分页查询管理员权限")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "page", value = "当前页", required = true, dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "limit", value = "每页条数", required = true, dataType = "int")
    })
    @PostMapping("paging")
    public Result<List<SaasUserPermissionList>> paging(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer limit, @Validated SaasUserPermissionPagingRequestVo saasUserPermissionPagingRequestVo) {
        IPage<SaasUserPermissionList> saasUserRoleTypeIPage = new Page<>(page, limit);//参数一是当前页，参数二是每页个数
        //组装查询器
        QueryWrapper<SaasUserPermissionList> saasUserQueryWrapper=new QueryWrapper<SaasUserPermissionList>();
        saasUserQueryWrapper.lambda()
                .eq(SaasUserPermissionList::getParentId,saasUserPermissionPagingRequestVo.getParentId())
                .like(!StringUtils.isEmpty(saasUserPermissionPagingRequestVo.getKeywords()),SaasUserPermissionList::getName,saasUserPermissionPagingRequestVo.getKeywords());
        saasUserQueryWrapper.orderByAsc("sort");
        IPage<SaasUserPermissionList> saasUserRoleTypeIPage1= saasUserPermissionListService.page(saasUserRoleTypeIPage,saasUserQueryWrapper);
        List<SaasUserPermissionList> saasUserRoleTypeList=saasUserRoleTypeIPage1.getRecords();
        Result<List<SaasUserPermissionList>> result=Result.retrunSucessMsgData(saasUserRoleTypeList);
        result.setCount(saasUserRoleTypeIPage1.getTotal());
        return result;
    }

    @PostMapping("listByRoleId")
    public Map<String,Object> listByRoleId(Long saasUserRoleId){
        List<SaasUserPermissionList> permissionList=saasUserPermissionListService.list();
        Map<String,Object> listByRoleIdMap=new HashMap<>();
        listByRoleIdMap.put("roleId",saasUserRoleId);
        List<Long> permissionIdList=saasUserRolePermissionService.listByRoleId(saasUserRoleId);


        Map<String,Object> map=new HashMap<>();
        Map<String,Object> m=new HashMap<>();


        m.put("list",permissionList);
        m.put("checkedId",permissionIdList.toArray());
        m.put("roleId",saasUserRoleId);
        map.put("code",0);
        map.put("msg","获取成功");
        map.put("data",m);
        return map;
    }
}



package com.example.springbootmybatisplus.web.controller;


import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springbootmybatisplus.aop.role.SocketRole;
import com.example.springbootmybatisplus.enums.Result;
import com.example.springbootmybatisplus.model.SaasUserRolePermission;
import com.example.springbootmybatisplus.model.SaasUserRoleType;
import com.example.springbootmybatisplus.model.vo.request.saasuser.role.SaasUserRoleTypeAddRequestVo;
import com.example.springbootmybatisplus.model.vo.request.saasuser.role.SaasUserRoleTypePagingRequestVo;
import com.example.springbootmybatisplus.model.vo.request.saasuser.role.SaasUserRoleTypeUpdateRequestVo;
import com.example.springbootmybatisplus.service.ISaasUserRolePermissionService;
import com.example.springbootmybatisplus.service.ISaasUserRoleTypeService;
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
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ZongjieWu
 * @since 2020-04-20
 */
/**
 *
 * Created by Zongjie Wu on 2020/04/14.
 */
@Api(tags = "3.平台管理员角色",description = "添加、修改、删除、查询等接口")
@RestController
@RequestMapping("/saasUserRoleType/")
public class SaasUserRoleTypeController {

    @Autowired
    private ISaasUserRoleTypeService saasUserRoleTypeService;
    @Autowired
    private ISaasUserRolePermissionService saasUserRolePermissionService;

    @ApiOperation(value = "平台管理员角色添加",notes = "平台管理员角色添加")
    @SocketRole(value = "add_saasUserRoleType")
    @PostMapping("add")
    public Result add(@Validated SaasUserRoleTypeAddRequestVo saasUserRoleTypeAddRequestVo) {
        SaasUserRoleType saasUserRoleType=BeanCopyTools.copy(saasUserRoleTypeAddRequestVo,SaasUserRoleType.class);
        saasUserRoleType.setAddTime(new Date());
        saasUserRoleType.setModifyTime(new Date());
        saasUserRoleTypeService.save(saasUserRoleType);
        return Result.retrunSucess();
    }

    @ApiOperation(value = "平台管理员角色的删除",notes = "平台管理员角色的删除")
    @ApiImplicitParam(paramType = "query",name = "id",value = "平台管理员角色表id",required = true,dataType = "int")
    @SocketRole(value = "delete_saasUserRoleType")
    @PostMapping("delete")
    public Result delete(@RequestParam Long id) {
        saasUserRoleTypeService.removeById(id);
        return Result.retrunSucess();
    }

    @ApiOperation(value = "平台管理员角色修改",notes = "平台管理员角色修改")
    @SocketRole(value = "update_saasUserRoleType")
    @PostMapping("update")
    public Result update(@Validated SaasUserRoleTypeUpdateRequestVo saasUserRoleTypeUpdateRequestVo) {
        SaasUserRoleType saasUserRoleType= BeanCopyTools.copy(saasUserRoleTypeUpdateRequestVo,SaasUserRoleType.class);
        saasUserRoleType.setModifyTime(new Date());
        saasUserRoleTypeService.updateById(saasUserRoleType);
        return Result.retrunSucess();
    }

//    @ApiIgnore
//    @OpenAppApiCheck(value = "detail_saasUserRoleType")
//    @GetMapping("detail")
//    public Result<SaasUserRoleType> detail(@RequestParam Long id) {
//        SaasUserRoleType saasUserRoleType = saasUserRoleTypeService.findById(id);
//        return Result.retrunSucessMsgData(saasUserRoleType);
//    }

    @ApiOperation(value = "获取角色列表",notes = "获取角色列表")
//    @OpenAppApiCheck(value = "list_saasUserRoleType")
    @GetMapping("list")
    public Result<List<SaasUserRoleType>> list() {
        List<SaasUserRoleType> saasUserRoleType = saasUserRoleTypeService.list();
        return Result.retrunSucessMsgData(saasUserRoleType);
    }

    @ApiIgnore
//    @OpenAppApiCheck(value = "pageing_saasUserRoleType")
    @PostMapping("paging")
    public Result<List<SaasUserRoleType>> paging(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer limit,@Validated SaasUserRoleTypePagingRequestVo saasUserRoleTypePagingRequestVo) {
        IPage<SaasUserRoleType> saasUserRoleTypeIPage = new Page<>(page, limit);//参数一是当前页，参数二是每页个数
        //组装查询器
        QueryWrapper<SaasUserRoleType> saasUserQueryWrapper=new QueryWrapper<SaasUserRoleType>();
        saasUserQueryWrapper.lambda()
        .like(!StringUtils.isEmpty(saasUserRoleTypePagingRequestVo.getKeywords()),SaasUserRoleType::getName,saasUserRoleTypePagingRequestVo.getKeywords());
        IPage<SaasUserRoleType> saasUserRoleTypeIPage1= saasUserRoleTypeService.page(saasUserRoleTypeIPage,saasUserQueryWrapper);
        List<SaasUserRoleType> saasUserRoleTypeList=saasUserRoleTypeIPage1.getRecords();
        Result<List<SaasUserRoleType>> result=Result.retrunSucessMsgData(saasUserRoleTypeList);
        result.setCount(saasUserRoleTypeIPage1.getTotal());
        return result;
    }

    @ApiOperation(value = "平台管理员角色权限的修改",notes = "平台管理员角色权限的修改")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query" ,name="rid",value = "角色id",required = true,dataType = "int"),
            @ApiImplicitParam(paramType = "query",name="authids",value = "权限id字符串,用逗号(,)隔开",required = true,dataType = "string")
    })
    @PostMapping("updatePermission")
    public Result updatePermission(Long rid, String authids){
        String[] authidsArr=authids.split(",");
        /*
        * 先删除再添加
        * **/
        SaasUserRolePermission erp=new SaasUserRolePermission();
        erp.setSaasUserRoleId(rid);
        try {
            synchronized (SaasUserRolePermission.class){
                QueryWrapper<SaasUserRolePermission> saasUserRolePermissionQueryWrapper=new QueryWrapper<>();
                saasUserRolePermissionQueryWrapper.lambda().eq(SaasUserRolePermission::getSaasUserRoleId,rid);
                saasUserRolePermissionService.remove(saasUserRolePermissionQueryWrapper);
            }
            if(authids.trim().length()>0){
                SaasUserRolePermission saasUserRolePermission=null;
                for(int i=0;i<authidsArr.length;i++){
                    saasUserRolePermission=new SaasUserRolePermission();
                    saasUserRolePermission.setSaasUserRoleId(rid);
                    saasUserRolePermission.setSaasUserPermissionId(Long.parseLong(authidsArr[i]));
                    saasUserRolePermissionService.save(saasUserRolePermission);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return Result.retrunSucess();
    }

}



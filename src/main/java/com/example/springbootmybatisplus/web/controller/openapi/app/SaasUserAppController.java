package com.example.springbootmybatisplus.web.controller.openapi.app;


import com.example.springbootmybatisplus.aop.openapicheck.OpenAppApiCheck;
import com.example.springbootmybatisplus.enums.Result;
import com.example.springbootmybatisplus.model.SaasUser;
import com.example.springbootmybatisplus.model.vo.request.saasuser.user.SaasUserAddRequestVo;
import com.example.springbootmybatisplus.model.vo.request.saasuser.user.SaasUserPagingRequestVo;
import com.example.springbootmybatisplus.model.vo.request.saasuser.user.SaasUserUpdateRequestVo;
import com.example.springbootmybatisplus.model.vo.response.SaasUserBaseInfoResponseVo;
import com.example.springbootmybatisplus.service.ISaasUserService;
import com.example.springbootmybatisplus.util.AESUtil;
import com.example.springbootmybatisplus.util.BeanCopyTools;
import com.example.springbootmybatisplus.util.MD5Util;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static com.example.springbootmybatisplus.service.impl.SaasUserLoginiServiceImpl.AES_KEY;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ZongjieWu
 * @since 2020-04-19
 */
@Api(tags = "6.开放接口平台管理员",description = "添加、修改、删除、查询等接口")
@RestController
@RequestMapping("/openapi/saasUser")
public class SaasUserAppController {
    @Autowired
    private ISaasUserService saasUserService;

    @OpenAppApiCheck()
    @GetMapping("/detail")
    public Result<SaasUser> detail(Long id){
        return Result.retrunSucessMsgData(saasUserService.getById(id));
    }


    @ApiOperation(value = "管理员添加",notes = "管理员添加")
    @OpenAppApiCheck()
    @PostMapping("/add")
    public Result add(@Validated SaasUserAddRequestVo saasUserAddRequestVo) {
        SaasUser saasUser=BeanCopyTools.copy(saasUserAddRequestVo,SaasUser.class);
        saasUser.setPwd(MD5Util.getMD5(AESUtil.encode(saasUser.getPwd(), AES_KEY)));
        saasUser.setAddTime(new Date());
        saasUser.setModifyTime(new Date());
        saasUserService.save(saasUser);
        return Result.retrunSucess();
    }

    @ApiOperation(value = "管理员删除",notes = "管理员删除")
    @ApiImplicitParam(paramType = "query",name = "id",value = "管理员表id",required = true,dataType = "int")
    @OpenAppApiCheck()
    @PostMapping("delete")
    public Result delete(@RequestParam Long id) {
        saasUserService.removeById(id);
        return Result.retrunSucess();
    }

    @ApiOperation(value = "管理员修改",notes = "管理员修改")
    @OpenAppApiCheck()
    @PostMapping("update")
    public Result update(@Validated SaasUserUpdateRequestVo saasUserUpdateRequestVo) {
        SaasUser saasUser=BeanCopyTools.copy(saasUserUpdateRequestVo,SaasUser.class);
        if(null!=saasUser.getPwd() && !("").equals(saasUser.getPwd())){
            saasUser.setPwd(MD5Util.getMD5(AESUtil.encode(saasUser.getPwd(), AES_KEY)));
        }
        saasUser.setModifyTime(new Date());
        saasUserService.updateById(saasUser);
        return Result.retrunSucess();
    }

    @OpenAppApiCheck()
    @ApiOperation(value = "分页查询管理员",notes = "分页查询管理员")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "page", value = "当前页", required = true, dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "limit", value = "每页的条数", required = true, dataType = "int")
    })
    @PostMapping("paging")
    public Result<List<SaasUserBaseInfoResponseVo>> paging(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer limit, SaasUserPagingRequestVo saasUserPagingRequestVo) {
        Result<List<SaasUserBaseInfoResponseVo>> listResult=saasUserService.paging(page,limit,saasUserPagingRequestVo);
        return listResult;
    }
}


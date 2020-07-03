package com.example.springbootmybatisplus.model.vo.request.saasuser.permission;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@ApiModel(description = "权限修改请求数据")
@Data
public class SaasUserPermissionUpdateRequestVo extends SaasUserPermissionAddRequestVo{
    /**
     * 权限表id
     */
    @NotNull
    @ApiModelProperty(value = "权限表id",required = true)
    private Long id;
}

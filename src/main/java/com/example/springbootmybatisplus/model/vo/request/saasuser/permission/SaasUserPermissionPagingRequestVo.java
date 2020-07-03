package com.example.springbootmybatisplus.model.vo.request.saasuser.permission;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@ApiModel(description = "获取权限列表请求数据")
@Data
public class SaasUserPermissionPagingRequestVo {
    @NotNull
    @ApiModelProperty(value = "父级权限id",required = true)
    private Long parentId;

    @ApiModelProperty(value = "搜索关键词",required = false)
    private String keywords;
}

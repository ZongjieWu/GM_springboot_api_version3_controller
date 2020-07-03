package com.example.springbootmybatisplus.model.vo.request.saasuser.permission;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel(description = "权限添加请求数据")
@Data
public class SaasUserPermissionAddRequestVo {

    /**
     * 父级权限id
     */
    @NotNull
    @ApiModelProperty(value = "父级权限id",required = true)
    private Long parentId;

    /**
     * 名称
     */
    @NotBlank
    @ApiModelProperty(value = "名称",required = true)
    private String name;

    /**
     * 描述
     */
    @NotBlank
    @ApiModelProperty(value = "描述",required = true)
    private String descript;

    /**
     * 请求路径
     */
    @ApiModelProperty(value = "请求路径",required = false)
    private String requestPath;


    /**
     * 图标路径
     */
    @ApiModelProperty(value = "请求路径",required = false)
    private String iconPath;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序",required = false)
    private Integer sort;
}

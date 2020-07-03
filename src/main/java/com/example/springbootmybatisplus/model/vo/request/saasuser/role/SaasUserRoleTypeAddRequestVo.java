package com.example.springbootmybatisplus.model.vo.request.saasuser.role;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;



@ApiModel(description = "平台管理员角色添加请求数据")
@Data
public class SaasUserRoleTypeAddRequestVo {
    /**
     * 角色名称
     */
    @ApiModelProperty(value = "名称",required = true,position = 0)
    private String name;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述",required = false,position = 1)
    private String descript;

}

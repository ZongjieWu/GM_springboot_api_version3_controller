package com.example.springbootmybatisplus.model.vo.request.saasuser.role;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@ApiModel(description = "平台管理员角色添加请求数据")
@Data
public class SaasUserRoleTypeUpdateRequestVo extends SaasUserRoleTypeAddRequestVo{
    /**
     * 角色表id
     */
    @ApiModelProperty(value = "角色表id",required = true)
    private Long id;


}

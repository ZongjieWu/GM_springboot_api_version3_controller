package com.example.springbootmybatisplus.model.vo.request.saasuser.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@ApiModel(description = "平台管理员添加请求数据")
@Data
public class SaasUserUpdateRequestVo extends SaasUserAddRequestVo{
    @ApiModelProperty(value = "平台管理员的表id",required = true)
    private Long id;
}

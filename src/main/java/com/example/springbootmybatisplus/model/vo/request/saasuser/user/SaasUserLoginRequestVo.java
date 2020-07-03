package com.example.springbootmybatisplus.model.vo.request.saasuser.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@ApiModel(description = "平台管理员登入请求数据")
@Data
public class SaasUserLoginRequestVo {
    @NotBlank
    @ApiModelProperty(value = "电话号码",required = true)
    private String phone;
    @NotBlank
    @ApiModelProperty(value = "密码",required = true)
    private String pwd;
}

package com.example.springbootmybatisplus.model.vo.request.saasuser.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@ApiModel(description = "平台管理员获取分页请求数据")
@Data
public class SaasUserPagingRequestVo {
    @ApiModelProperty(value = "关键词",required = false)
    private String keywords;
}

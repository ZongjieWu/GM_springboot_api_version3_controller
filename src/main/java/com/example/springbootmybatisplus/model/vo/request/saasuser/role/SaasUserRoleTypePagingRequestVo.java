package com.example.springbootmybatisplus.model.vo.request.saasuser.role;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@ApiModel(description = "平台管理员角色获取分页列表请求数据")
@Data
public class SaasUserRoleTypePagingRequestVo {
    /**
     * 关键词
     */
    @ApiModelProperty(value = "关键词",required = false,position = 0)
    private String keywords;
}

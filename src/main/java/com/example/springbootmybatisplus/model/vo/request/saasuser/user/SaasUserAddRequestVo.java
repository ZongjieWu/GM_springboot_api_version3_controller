package com.example.springbootmybatisplus.model.vo.request.saasuser.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@ApiModel(description = "平台管理员添加请求数据")
@Data
public class SaasUserAddRequestVo {
    /**
     * 管理员角色id
     */
    @ApiModelProperty(value = "角色id",required = true,position = 1)
    private Long saasUserRoleId;

    /**
     * 头像
     */
    @ApiModelProperty(value = "头像",required = false,position = 2)
    private String headImg;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称",required = false,position = 3)
    private String name;

    /**
     * 电话
     */
    @ApiModelProperty(value = "电话",required = true,position = 4)
    private String phone;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码",required = true,position = 5)
    private String pwd;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱",required = false,position = 6)
    private String email;

    /**
     * 联系地址
     */
    @ApiModelProperty(value = "联系地址",required = false,position = 1)
    private String addr;

    /**
     * 身份证
     */
    @ApiModelProperty(value = "身份证",required = false,position = 1)
    private String idCard;
}

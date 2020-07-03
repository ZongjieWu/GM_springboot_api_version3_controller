package com.example.springbootmybatisplus.model.vo.response;

import com.example.springbootmybatisplus.model.SaasUserPermissionList;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@ApiModel(description = "后台管理员基本信息实体响应数据")
@Data
public class SaasUserBaseInfoResponseVo {
    /**
     * 管理员
     */
    @ApiModelProperty(value = "平台管理员表id")
    private Long id;

    /**
     * 管理员角色id
     */
    @ApiModelProperty(value = "管理员角色id")
    private Long saasUserRoleId;

    /**
     * 头像
     */
    @ApiModelProperty(value = "头像")
    private String headImg;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;

    /**
     * 电话
     */
    @ApiModelProperty(value = "电话")
    private String phone;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    private String email;

    /**
     * 联系地址
     */
    @ApiModelProperty(value = "联系地址")
    private String addr;

    /**
     * 身份证
     */
    @ApiModelProperty(value = "身份证")
    private String idCard;

    /**
     * 添加时间
     */
    @ApiModelProperty(value = "添加时间")
    private Date addTime;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
    private Date modifyTime;

    /**
     * 用户认证标识
     */
    private String token;



    /**
     * #####################################################################################################
     * 以下存放非表映射字段
     * #####################################################################################################
     */

    /**
     * 管理员角色id
     */
    private String saasUserRoleName;


    private List<SaasUserPermissionList> saasUserPermissionList;

}

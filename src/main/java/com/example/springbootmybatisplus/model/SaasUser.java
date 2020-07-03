package com.example.springbootmybatisplus.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

import java.beans.Transient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author ZongjieWu
 * @since 2020-04-19
 */
@Data
//@EqualsAndHashCode(callSuper = false)
//@Accessors(chain = true)
@TableName("s_saas_user")
public class SaasUser implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 员工
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 员工角色id
     */
    @TableField("saas_user_role_id")
    private Long saasUserRoleId;

    /**
     * 开放平台的ak(开发者唯一标识)
     */
    @TableField("access_key")
    private String accessKey;

    /**
     * 开放平台密钥(用于签名,即接口加密)
     */
    @TableField("secret_key")
    private String secretKey;

    /**
     * 开放平台app(用户唯一标识)
     */
    @TableField("token")
    private String token;

    /**
     * 开放平台app密钥(用于加密,即接口加密)
     */
    @TableField("app_key")
    private String appKey;

    /**
     * 头像
     */
    @TableField("head_img")
    private String headImg;

    /**
     * 名称
     */
    @TableField("name")
    private String name;

    /**
     * 电话
     */
    @TableField("phone")
    private String phone;

    /**
     * 密码
     */
    @TableField("pwd")
    private String pwd;

    /**
     * 邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 联系地址
     */
    @TableField("addr")
    private String addr;

    /**
     * 身份证
     */
    @TableField("id_card")
    private String idCard;

    /**
     * 0正常状态1离职(冻结)
     */
    @TableField("status")
    private Integer status;

    /**
     * 添加时间
     */
    @TableField("add_time")
    private Date addTime;

    /**
     * 修改时间
     */
    @TableField("modify_time")
    private Date modifyTime;


    /**
     * #####################################################################################################
     * 以下存放非表映射字段
     * #####################################################################################################
     */
    @TableField(exist = false)
    private String saasUserRoleName;

    @TableField(exist = false)
    List<SaasUserPermissionList> saasUserPermissionList;

}

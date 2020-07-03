package com.example.springbootmybatisplus.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author ZongjieWu
 * @since 2020-04-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("s_saas_user_role_permission")
public class SaasUserRolePermission implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 员工角色权限id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 员工角色id
     */
    @TableField("saas_user_role_id")
    private Long saasUserRoleId;

    /**
     * 员工权限id
     */
    @TableField("saas_user_permission_id")
    private Long saasUserPermissionId;

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


}

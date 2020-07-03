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
//@Accessors(chain = true)
@TableName("s_saas_user_role_type")
public class SaasUserRoleType implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 员工角色id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 角色名称
     */
    @TableField("name")
    private String name;

    /**
     * 描述
     */
    @TableField("descript")
    private String descript;

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

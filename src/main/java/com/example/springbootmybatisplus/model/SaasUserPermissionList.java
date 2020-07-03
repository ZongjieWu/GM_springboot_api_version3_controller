package com.example.springbootmybatisplus.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
//@Accessors(chain = true)
@TableName("s_saas_user_permission_list")
public class SaasUserPermissionList implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 员工权限表
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 父级权限id
     */
    @TableField("parent_id")
    private Long parentId;

    /**
     * 名称
     */
    @TableField("name")
    private String name;

    /**
     * 描述
     */
    @TableField("descript")
    private String descript;

    /**
     * 请求路径
     */
    @TableField("request_path")
    private String requestPath;
    /**
     * 图标路径
     */
    @TableField("icon_path")
    private String iconPath;

    /**
     * 排序
     */
    @TableField("sort")
    private Integer sort;

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
    List<SaasUserPermissionList> saasUserPermissionList;


}

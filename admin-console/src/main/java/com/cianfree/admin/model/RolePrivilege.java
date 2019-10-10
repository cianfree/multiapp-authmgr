package com.cianfree.admin.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * 角色权限
 *
 * @author Arvin
 * @since 2019-10-10
 */
@Data
public class RolePrivilege {

    /** 主键ID **/
    @TableId(type = IdType.AUTO)
    private Long id;

    /** 所属应用ID **/
    private Long appId;

    /** 角色代号,对应 role.code **/
    private String roleCode;

    /** 权限代号，对应 privilege.code **/
    private String privilegeCode;

    /** 创建时间 **/
    private Date createTime;
}

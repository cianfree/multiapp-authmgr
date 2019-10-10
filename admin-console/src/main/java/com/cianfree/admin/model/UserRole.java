package com.cianfree.admin.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * @author Arvin
 * @since 2019-10-10
 */
@Data
public class UserRole {

    /** 主键ID **/
    @TableId(type = IdType.AUTO)
    private Long id;

    /** 所属应用ID **/
    private Long appId;

    /** 用户账号,对应 user.account **/
    private String userAccount;

    /** 角色code，对应 role.code **/
    private String roleCode;

    /** 创建时间 **/
    private Date createTime;
}

package com.cianfree.admin.form;

import lombok.Data;

/**
 * @author xiajiqiu
 * @version 1.0
 * @since 2019/12/31 22:09
 */
@Data
public class PrivilegeQueryForm {

    /** 等值查询：应用ID，和 account 组成唯一主键 **/
    private Integer appId;

    /** 模糊查询：用户账号，和appId组成唯一主键 **/
    private String account;
}

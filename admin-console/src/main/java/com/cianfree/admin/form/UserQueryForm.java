package com.cianfree.admin.form;

import lombok.Data;

import java.util.Date;

/**
 * 用户查询表单
 * @author Arvin
 * @since 2019-10-10
 */
@Data
public class UserQueryForm extends PageQueryForm {

    /** 等值查询：应用ID，和 account 组成唯一主键 **/
    private Integer appId;

    /** 模糊查询：用户账号，和appId组成唯一主键 **/
    private String account;

    /** 等值查询：用户状态，是否启用，true-启用，false-禁用 **/
    private Boolean enabled;

    /** 模糊查询：姓名 **/
    private String name;

    /** 模糊查询：邮件地址 **/
    private String email;

    /** 模糊查询：联系电话 **/
    private String mobile;

    /** 模糊查询：QQ **/
    private String qq;

    /** 模糊查询：微信 **/
    private String weixin;

    /** 创建时间 **/
    private Date begCreateTime;
    private Date endCreateTime;

    /** 最后一次更新事件 **/
    private Date begUpdateTime;
    private Date endUpdateTime;

}

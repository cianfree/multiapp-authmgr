package com.cianfree.admin.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 用户
 * @author Arvin
 * @since 2019-10-10
 */
@Data
@ToString
public class User {

    /** 主键ID，自增 **/
    @TableId(type = IdType.AUTO)
    private Long id;

    /** 应用ID，和 account 组成唯一主键 **/
    private Integer appId;

    /** 用户账号，和appId组成唯一主键 **/
    private String account;

    /** 用户状态，是否启用，true-启用，false-禁用 **/
    private Boolean enabled;

    /** 姓名 **/
    private String name;

    /** 邮件地址 **/
    private String email;

    /** 联系电话 **/
    private String mobile;

    /** QQ **/
    private String qq;

    /** 微信 **/
    private String weixin;

    /** 备注信息 **/
    private String remark;

    /** 创建时间 **/
    private Date createTime;

    /** 最后一次更新事件 **/
    private Date updateTime;

}

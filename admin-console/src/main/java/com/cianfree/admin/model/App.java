package com.cianfree.admin.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 接入的应用
 * @author Arvin
 * @since 2019-10-10
 */
@Data
@ToString
public class App {

    /** 自增主键ID **/
    @TableId(type = IdType.AUTO)
    private Long id;

    /** 唯一ID，提供给业务方 **/
    private Integer appId;

    /** 应用名称 **/
    private String name;

    /** 联系人姓名列表 **/
    private String contactNames;

    /** 联系人电话列表 **/
    private String contactMobiles;

    /** 应用联系邮箱电话列表 **/
    private String contactEmails;

    /** 联系QQ列表 **/
    private String contactQqs;

    /** 微信列表 **/
    private String contactWeixins;

    /** 应用地址 **/
    private String address;

    /** 应用备注信息，即用于做什么 **/
    private String remark;

    /** 创建时间 **/
    private Date createTime;

    /** 最后一次更新事件 **/
    private Date updateTime;

}

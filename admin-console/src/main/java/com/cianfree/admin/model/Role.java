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
public class Role {

    /** 主键ID **/
    @TableId(type = IdType.AUTO)
    private Long id;

    /** 所属应用ID **/
    private Long appId;

    /** 便于记忆的 角色CODE **/
    private String code;

    /** 角色名称 **/
    private String name;

    /** 备注信息 **/
    private String remark;

    /** 创建时间 **/
    private Date createTime;

    /** 更新时间 **/
    private Date updateTime;

    /** 扩展字段信息 **/
    private String extend;

}

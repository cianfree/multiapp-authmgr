package com.cianfree.admin.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * 权限项
 * @author Arvin
 * @since 2019-10-10
 */
@Data
public class Privilege {

    /** 主键ID **/
    @TableId(type = IdType.AUTO)
    private Long id;

    /** 所属应用ID **/
    private Long appId;

    /** 便于记忆的 权限 CODE，具有层级关系的 **/
    private String code;

    /** 上级权限代码 **/
    private String parentCode;

    /** 是否展示为菜单项 **/
    private Boolean showMenu;

    /** 权限名称 **/
    private String name;

    /** 权限名称路径，把上级名称带上，类似: 用户管理/用户添加 **/
    private String namePath;

    /** 资源列表，如一个或多个 url，中间用英文逗号分隔 **/
    private String resources;

    /** 备注信息 **/
    private String remark;

    /** 创建时间 **/
    private Date createTime;

    /** 更新时间 **/
    private Date updateTime;

}

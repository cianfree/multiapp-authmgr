package com.cianfree.admin.vo;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * @author xiajiqiu
 * @version 1.0
 * @since 2019/12/31 22:02
 */
@Data
@ToString
public class PrivilegeVO {

    /** 主键ID **/
    private Long id;

    /** 所属应用ID **/
    private Long appId;

    /** 便于记忆的 权限 CODE **/
    private String code;

    /** 便于记忆的 权限 CODE路径，具有层级关系的 **/
    private String codePath;

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

    /** 扩展字段信息 **/
    private String extend;

    /** 子权限列表 **/
    private List<PrivilegeVO> children;
}

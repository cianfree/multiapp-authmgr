package com.cianfree.admin.dao;

import com.cianfree.admin.model.Privilege;

import java.util.List;

/**
 * @author xiajiqiu
 * @version 1.0
 * @since 2019/12/31 22:17
 */
public interface PrivilegeDao {

    /**
     * 查询指定 APPID 下某个用户的 权限列表
     *
     * @param appId   应用ID
     * @param account 账号
     * @return 权限列表
     */
    List<Privilege> listUserPrivileges(Integer appId, String account);
}

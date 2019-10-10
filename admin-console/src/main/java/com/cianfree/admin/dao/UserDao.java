package com.cianfree.admin.dao;

import com.cianfree.admin.model.User;

/**
 * @author Arvin
 * @since 2019-10-10
 */
public interface UserDao {

    /**
     * 获取指定用户的UID
     *
     * @param uid 用户UID
     * @return user
     */
    User get(Long uid);
}

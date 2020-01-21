package com.cianfree.admin.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cianfree.admin.model.User;
import com.cianfree.admin.query.UserQuery;

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

    /**
     * 分页查询用户信息
     *
     * @param query    查询条件
     * @param pageNo   第几页
     * @param pageSize 每页多少
     * @return 分页数据
     */
    Page<User> queryPage(UserQuery query, long pageNo, long pageSize);
}

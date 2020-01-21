package com.cianfree.admin.services;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cianfree.admin.dao.UserDao;
import com.cianfree.admin.model.User;
import com.cianfree.admin.query.UserQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Arvin
 * @since 2019-10-10
 */
@Service
public class UserService extends BaseService {

    @Autowired
    private UserDao userDao;

    /**
     * 获取用户信息
     *
     * @param id 用户ID
     * @return 用户信息
     */
    public User get(Long id) {
        return userDao.get(id);
    }

    /**
     * 分页查询用户信息
     *
     * @param query    查询条件
     * @param pageNo   页码
     * @param pageSize 每页查询数量
     * @return 分页数据
     */
    public Page<User> queryPage(UserQuery query, long pageNo, long pageSize) {
        return userDao.queryPage(query, pageNo, pageSize);
    }
}

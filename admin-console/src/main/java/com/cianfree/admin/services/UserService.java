package com.cianfree.admin.services;

import com.cianfree.admin.dao.UserDao;
import com.cianfree.admin.model.User;
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
}

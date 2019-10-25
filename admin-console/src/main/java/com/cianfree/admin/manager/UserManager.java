package com.cianfree.admin.manager;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cianfree.admin.form.UserQueryForm;
import com.cianfree.admin.model.User;
import com.cianfree.admin.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Arvin
 * @since 2019-10-10
 */
@Component
public class UserManager extends BaseManager {

    @Autowired
    private UserService userService;

    public User get(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("param id is required!");
        }
        return userService.get(id);
    }

    public Page<User> query(UserQueryForm query, long pageNo, long pageSize) {
        return userService.queryPage(query, pageNo, pageSize);
    }
}

package com.cianfree.admin.controller.api;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cianfree.admin.controller.BaseController;
import com.cianfree.admin.form.UserQueryForm;
import com.cianfree.admin.manager.UserManager;
import com.cianfree.admin.model.User;
import com.cianfree.admin.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户API接口
 *
 * @author Arvin
 * @since 2019-10-10
 */
@RestController
public class UserApiController extends BaseController {

    @Autowired
    private UserManager userManager;

    /**
     * 获取用户信息
     *
     * @param id 用户ID
     * @return user
     */
    @GetMapping("/api/user/get/{id}")
    public Result<User> get(@PathVariable("id") Long id) {
        return new Result<User>(userManager.get(id));
    }

    /**
     * 查询用户列表
     *
     * @param query 查询条件
     * @return 用户列表
     */
    @PostMapping("/api/user/query")
    public Result<Page<User>> query(UserQueryForm query, Long pageNo, Long pageSize) {
        return new Result<>(userManager.query(query, pageNo, pageSize));
    }
}

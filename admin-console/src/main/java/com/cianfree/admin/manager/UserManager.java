package com.cianfree.admin.manager;

import com.cianfree.admin.form.UserQueryForm;
import com.cianfree.admin.query.Page;
import com.cianfree.admin.services.UserService;
import com.cianfree.admin.util.ModelUtil;
import com.cianfree.admin.vo.UserVo;
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

    public UserVo get(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("param id is required!");
        }
        return ModelUtil.toUserVo(userService.get(id));
    }

    public Page<UserVo> query(UserQueryForm query) {

    }
}

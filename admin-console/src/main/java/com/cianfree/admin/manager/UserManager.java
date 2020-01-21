package com.cianfree.admin.manager;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cianfree.admin.model.Privilege;
import com.cianfree.admin.model.User;
import com.cianfree.admin.query.UserQuery;
import com.cianfree.admin.services.PrivilegeService;
import com.cianfree.admin.services.UserService;
import com.cianfree.admin.util.PrivilegeUtil;
import com.cianfree.admin.vo.PrivilegeVO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Arvin
 * @since 2019-10-10
 */
@Component
public class UserManager extends BaseManager {

    private final UserService userService;
    private final PrivilegeService privilegeService;

    public UserManager(UserService userService, PrivilegeService privilegeService) {
        this.userService = userService;
        this.privilegeService = privilegeService;
    }

    public User get(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("param id is required!");
        }
        return userService.get(id);
    }

    public Page<User> query(UserQuery query, long pageNo, long pageSize) {
        return userService.queryPage(query, pageNo, pageSize);
    }

    /**
     * 查询用户权限
     *
     * @param appId   应用APPID
     * @param account 账号
     * @return 权限列表，非 null
     */
    public List<PrivilegeVO> queryPrivileges(Integer appId, String account) {
        List<Privilege> privileges = privilegeService.listUserPrivileges(appId, account);

        // 转换成 tree
        return PrivilegeUtil.toPrivilegeTreeVo(privileges);
    }
}

package com.cianfree.admin.dao.composite;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cianfree.admin.dao.UserDao;
import com.cianfree.admin.dao.mybatis.UserMapper;
import com.cianfree.admin.form.UserQueryForm;
import com.cianfree.admin.model.User;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author Arvin
 * @since 2019-10-10
 */
@Repository
@Primary
public class UserDaoCompositeImpl implements UserDao {

    @Resource
    private UserMapper userMapper;

    @Override
    public User get(Long uid) {
        if (null == uid || uid < 1) {
            return null;
        }
        return userMapper.selectById(uid);
    }

    @Override
    public Page<User> queryPage(UserQueryForm query, long pageNo, long pageSize) {

        Page<User> page = new Page<>(pageNo, pageSize);

        QueryWrapper<User> queryWrapper = new QueryWrapper<>(new User());

        userMapper.selectPage(page, queryWrapper);

        return page;
    }
}

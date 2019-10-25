package com.cianfree.admin.mapper;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cianfree.admin.dao.mybatis.UserMapper;
import com.cianfree.admin.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Arvin
 * @since 2019-10-10
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    public void testInsert() {

    }

    @Test
    public void testPage() {

        QueryWrapper<User> queryWrapper = new QueryWrapper<>(new User());

        Page<User> page = new Page<>(1, 10);

        IPage<User> userPage = userMapper.selectPage(page, queryWrapper);

        System.out.println(JSON.toJSONString(userPage));
    }

}
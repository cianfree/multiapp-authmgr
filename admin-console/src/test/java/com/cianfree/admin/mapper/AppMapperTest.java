package com.cianfree.admin.mapper;

import com.cianfree.admin.dao.mybatis.AppMapper;
import com.cianfree.admin.model.App;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

/**
 * @author Arvin
 * @since 2019-10-10
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppMapperTest {

    @Resource
    private AppMapper appMapper;

    @Test
    public void testInsert() {

        App app = new App();
        app.setAppId(10000);
        app.setName("权限管理后台");
        app.setCreateTime(new Date());
        app.setAddress("http://localhost:8081/");

        try {
            int ret = appMapper.insert(app);
            System.out.println("Ret: " + ret + ", app: " + app);
        } catch (DuplicateKeyException e) {
            System.out.println("数据已经存在： " + e.getMessage());
        }


    }

    @Test
    public void testList() {

        List<App> appList = appMapper.selectList(null);

        appList.forEach(System.out::println);

    }

}
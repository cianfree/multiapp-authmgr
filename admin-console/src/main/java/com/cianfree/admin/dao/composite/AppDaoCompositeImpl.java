package com.cianfree.admin.dao.composite;

import com.cianfree.admin.dao.AppDao;
import com.cianfree.admin.dao.mybatis.AppMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author xiajiqiu
 * @version 1.0
 * @since 2020/1/21 14:01
 */
@Repository
public class AppDaoCompositeImpl implements AppDao {

    @Resource
    private AppMapper appMapper;

}

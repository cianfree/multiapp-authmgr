package com.cianfree.admin.util;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

/**
 * @author xiajiqiu
 * @version 1.0
 * @since 2020/1/21 17:22
 */
public class MybatisUtil {

    private MybatisUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static <T> QueryWrapper<? extends T> buildQueryWrapper(Class<T> beanType, T query) {
        QueryWrapper<T> wrapper = new QueryWrapper<>();


        return wrapper;
    }
}

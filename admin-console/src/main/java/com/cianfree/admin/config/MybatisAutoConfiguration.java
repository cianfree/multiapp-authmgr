package com.cianfree.admin.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Arvin
 * @since 2019-10-10
 */
@Configuration
@MapperScan("com.cianfree.admin.dao.mybatis")
public class MybatisAutoConfiguration {
}

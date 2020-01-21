package com.cianfree.admin.common.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;

/**
 * 查询条件Bean
 *
 * @author xiajiqiu3
 * @date 2019/10/18
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {TYPE})
public @interface QueryBean {

}

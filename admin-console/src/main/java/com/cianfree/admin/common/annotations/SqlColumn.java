package com.cianfree.admin.common.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

/**
 * @author xiajiqiu3
 * @date 2019/10/18
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {FIELD})
public @interface SqlColumn {

    /**
     * 列名
     */
    String value() default "";

    /**
     * 是否使用下划线
     */
    boolean underline() default true;
}

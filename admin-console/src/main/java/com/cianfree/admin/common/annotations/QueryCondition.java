package com.cianfree.admin.common.annotations;

import com.cianfree.admin.common.CompareType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

/**
 * @author xiajiqiu
 * @version 1.0
 * @since 2019/11/7 20:31
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {FIELD})
public @interface QueryCondition {

    /**
     * 查询类型，默认是等值查询
     *
     * @return 查询类型
     */
    CompareType value() default CompareType.EQUAL;

    /** 对于字符串，是否执行 trim 操作后再比较 **/
    boolean trim() default true;

    /** 实际的属性 **/
    String refField() default "";

    /** 忽略该属性 **/
    boolean ignored() default false;

}

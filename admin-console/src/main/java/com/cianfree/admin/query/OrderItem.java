package com.cianfree.admin.query;

import lombok.Data;

/**
 * 排序项
 * @author Arvin
 * @since 2019-10-10
 */
@Data
public class OrderItem {

    /** 排序字段 **/
    private String field;

    /** 是否升序排序, 默认是true **/
    private Boolean asc = true;

    public OrderItem(String field, Boolean asc) {
        this.field = field;
        this.asc = asc == null ? true : asc;
    }
}

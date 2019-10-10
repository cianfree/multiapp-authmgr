package com.cianfree.admin.query;

import lombok.Data;

import java.util.List;

/**
 * @author Arvin
 * @since 2019-10-10
 */
@Data
public class Page<T> {

    /** 总数 **/
    private int total;

    /** 页码,从1开始 **/
    private int pageNo;

    /** 每页查询数量 **/
    private int pageSize;

    /** 记录列表 **/
    private List<T> records;

    public Page(int total, int pageNo, int pageSize, List<T> records) {
        this.total = total;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.records = records;
    }
}

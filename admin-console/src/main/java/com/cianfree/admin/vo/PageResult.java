package com.cianfree.admin.vo;

import lombok.Data;

import java.util.List;

/**
 * @author Arvin
 * @since 2019-10-10
 */
@Data
public class PageResult<T> extends Result<List<T>> {


    public PageResult(List<T> data) {
        super(data);
    }

    public PageResult(int code, String msg) {
        super(code, msg);
    }
}

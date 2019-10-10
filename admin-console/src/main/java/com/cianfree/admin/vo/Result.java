package com.cianfree.admin.vo;

import lombok.Data;

/**
 * @author Arvin
 * @since 2019-10-10
 */
@Data
public class Result<T> {

    /** 响应码，200 表示正常响应正常 **/
    private int code = 200;
    /** 响应消息 **/
    private String msg;

    /** 响应数据 **/
    private T data;

    public Result(T data) {
        this.data = data;
    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

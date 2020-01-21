package com.cianfree.admin.common;

/**
 * 比较类型
 *
 * @author xiajiqiu
 * @version 1.0
 * @since 2019/10/31 10:33
 */
public enum CompareType {

    /** 等值比较 **/
    EQUAL("=", "等值"),
    LT("<", "小于"),
    LTE("<=", "小于等于"),
    GT(">", "大于"),
    GTE(">=", "大于等于"),
    LIKE("like", "模糊查询"),
    IN("in", "模糊查询"),
    NOT_IN("not in", "模糊查询"),
    NOT_NULL("is not null", "非null"),
    IS_NULL("is null", "null查询"),

    ;

    private String operate;
    private String desc;

    CompareType(String operate, String desc) {
        this.operate = operate;
        this.desc = desc;
    }

    public String getOperate() {
        return operate;
    }

    public String getDesc() {
        return desc;
    }
}

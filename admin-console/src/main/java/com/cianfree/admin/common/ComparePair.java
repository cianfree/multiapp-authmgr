package com.cianfree.admin.common;

/**
 * @author xiajiqiu
 * @version 1.0
 * @since 2019/10/31 20:47
 */
public class ComparePair {

    /** 查询条件值 **/
    private Object value;

    /** 比较类型 **/
    private CompareType compareType;

    public ComparePair(Object value, CompareType compareType) {
        this.value = value;
        this.compareType = compareType;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public CompareType getCompareType() {
        return compareType;
    }

    public void setCompareType(CompareType compareType) {
        this.compareType = compareType;
    }
}

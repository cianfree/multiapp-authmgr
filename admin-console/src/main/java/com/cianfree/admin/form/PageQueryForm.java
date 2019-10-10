package com.cianfree.admin.form;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Arvin
 * @since 2019-10-10
 */
@Data
public class PageQueryForm {

    /** 查询页码 **/
    private Integer pageNo = 1;

    /** 每页查询数量 **/
    private Integer pageSize = 10;

    /** 排序项, 比如: name desc, age asc,... **/
    private String orderBy;

    /**
     * 添加排序，如果已经存在，那么久不添加
     * @param orderBy orderBy 子句，如 name desc, age asc,...
     */
    public void orderBy(String orderBy) {
        if (StringUtils.isBlank(orderBy)) {
            return ;
        }
        if (StringUtils.isBlank(this.orderBy)) {
            this.orderBy = orderBy;
        } else {
            String[] array = orderBy.split(",+");
            if (array.length > 0) {
                for (String orderItem : array) {
                    if (StringUtils.isNotBlank(orderBy)) {
                        orderItem = orderItem.trim();
                        String[] subArray = orderItem.trim().split("\\s+");
                        String orderField = subArray[0];
                        if (!this.orderBy.contains(orderField)) {
                            this.orderBy += "," + orderItem;
                        }
                    }
                }
            }
        }
    }
}

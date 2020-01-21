package com.cianfree.admin.query;

import com.cianfree.admin.common.annotations.QueryBean;
import com.cianfree.admin.model.User;
import lombok.Data;

import java.util.Date;

/**
 * 用户查询表单
 *
 * @author Arvin
 * @since 2019-10-10
 */
@Data
@QueryBean
public class UserQuery extends User {

    /** 创建时间 **/
    private Date begCreateTime;
    private Date endCreateTime;

    /** 最后一次更新事件 **/
    private Date begUpdateTime;
    private Date endUpdateTime;

}

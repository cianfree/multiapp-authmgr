package com.cianfree.admin.dao.composite;

import com.cianfree.admin.dao.PrivilegeDao;
import com.cianfree.admin.model.Privilege;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xiajiqiu
 * @version 1.0
 * @since 2019/12/31 22:17
 */
@Primary
@Repository
public class PrivilegeDaoCompositeImpl implements PrivilegeDao {

    @Override
    public List<Privilege> listUserPrivileges(Integer appId, String account) {
        return null;
    }
}

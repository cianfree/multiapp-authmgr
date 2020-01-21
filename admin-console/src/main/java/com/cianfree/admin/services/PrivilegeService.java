package com.cianfree.admin.services;

import com.cianfree.admin.dao.PrivilegeDao;
import com.cianfree.admin.model.Privilege;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xiajiqiu
 * @version 1.0
 * @since 2019/12/31 22:13
 */
@Service
public class PrivilegeService extends BaseService {

    private final PrivilegeDao privilegeDao;

    public PrivilegeService(PrivilegeDao privilegeDao) {
        this.privilegeDao = privilegeDao;
    }

    public List<Privilege> listUserPrivileges(Integer appId, String account) {
        return privilegeDao.listUserPrivileges(appId, account);
    }
}

package com.cianfree.admin.util;

import com.cianfree.admin.model.Privilege;
import com.cianfree.admin.vo.PrivilegeVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiajiqiu
 * @version 1.0
 * @since 2019/12/31 22:14
 */
public class PrivilegeUtil {

    private PrivilegeUtil() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * 转换成权限树
     *
     * @param privileges 权限列表
     * @return 权限树
     */
    public static List<PrivilegeVO> toPrivilegeTreeVo(List<Privilege> privileges) {
        List<PrivilegeVO> topList = new ArrayList<>();
        Map<String, PrivilegeVO> voMap = new HashMap<>();
        Map<String, List<PrivilegeVO>> childrenMap = new HashMap<>();

        for (Privilege privilege : privileges) {
            String parentCode = privilege.getParentCode();
            PrivilegeVO vo = new PrivilegeVO();
            BeanUtils.copyProperties(privilege, vo);
            voMap.put(vo.getCode(), vo);

            if (StringUtils.isBlank(parentCode)) {
                topList.add(vo);
                List<PrivilegeVO> children = childrenMap.computeIfAbsent(vo.getCode(), k -> new ArrayList<>());
                vo.setChildren(children);
            } else {
                // 有上级
                List<PrivilegeVO> children = childrenMap.computeIfAbsent(parentCode, k -> new ArrayList<>());
                children.add(vo);
                PrivilegeVO parent = voMap.get(parentCode);
                if (null != parent) {
                    parent.setChildren(children);
                }
            }
        }

        return topList;
    }
}

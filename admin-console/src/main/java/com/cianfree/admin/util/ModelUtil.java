package com.cianfree.admin.util;

import com.cianfree.admin.model.User;
import com.cianfree.admin.vo.UserVo;
import org.springframework.beans.BeanUtils;

/**
 * 模型转换工具类
 *
 * @author Arvin
 * @since 2019-10-10
 */
public class ModelUtil {

    private ModelUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static UserVo toUserVo(User user) {
        if (null == user) {
            return null;
        }
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(user, userVo);
        return userVo;
    }
}

package com.cianfree.admin.common;

import com.cianfree.admin.common.annotations.QueryBean;
import com.cianfree.admin.common.annotations.QueryCondition;
import com.cianfree.admin.common.annotations.SqlColumn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

/**
 * @author xiajiqiu
 * @version 1.0
 * @since 2020/1/21 17:47
 */
public class SqlUtil {

    private final static Logger logger = LoggerFactory.getLogger(SqlUtil.class);

    private SqlUtil() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * 属性回调处理
     */
    public interface FieldCallback {

        /**
         * 属性处理
         *
         * @param field 要处理的属性
         */
        void doWith(Field field);
    }

    public static void doWithQueryOrBeanFields(Class<?> clazz, FieldCallback callback) {
        assert callback != null;

        QueryBean queryBean = clazz.getAnnotation(QueryBean.class);
        if (queryBean == null) {
            Field[] fields = clazz.getDeclaredFields();
            if (fields.length < 1) {
                return;
            }
            for (Field field : fields) {
                callback.doWith(field);
            }
            return;
        }

        Class<?> superClass = clazz.getSuperclass();
        doWithQueryOrBeanFields(superClass, callback);

        Field[] queryBeanFields = clazz.getDeclaredFields();
        if (queryBeanFields.length < 1) {
            return;
        }
        for (Field field : queryBeanFields) {
            callback.doWith(field);
        }
    }

    /**
     * 获取查询条件
     *
     * @param queryBean 查询BEAN
     * @return key 为列名， value 为比较字段信息
     */
    public static Map<String, List<ComparePair>> getQueryBeanComparePairs(final Object queryBean) {
        final Map<String, List<ComparePair>> map = new HashMap<>();

        doWithQueryOrBeanFields(queryBean.getClass(), (field) -> {
            if (!isValidQueryConditionField(field)) {
                return;
            }

            field.setAccessible(true);
            Object object = null;
            try {
                object = field.get(queryBean);
            } catch (Exception e) {
                logger.warn("QueryBeanComparePairs error,bean:{},field:{},e:{}", queryBean, field.getName(), e, e);
            }
            if (object != null) {
                String columnName = SqlUtil.getSqlColumnName(field);
                List<ComparePair> pairs = map.computeIfAbsent(columnName, k -> new ArrayList<>());

                if (object instanceof String) {
                    QueryCondition qc = field.getAnnotation(QueryCondition.class);
                    if (null != qc && qc.trim()) {
                        object = ((String) object).trim();
                    }
                }

                pairs.add(new ComparePair(object, SqlUtil.getCompareType(field)));
            }

        });

        return map;
    }

    public static CompareType getCompareType(Field field) {
        QueryCondition qc = field.getAnnotation(QueryCondition.class);
        if (null != qc) {
            return qc.value();
        }

        // 默认是等于
        return CompareType.EQUAL;
    }

    public static String getSqlColumnName(Field field) {
        SqlColumn sqlColumn = field.getAnnotation(SqlColumn.class);
        if (sqlColumn != null) {
            String column = sqlColumn.value();
            if (!"".equals(column.trim())) {
                return sqlColumn.value();
            }

            if (sqlColumn.underline()) {
                return SqlUtil.underlineName(field.getName());
            }
        }

        Class<?> beanClazz = field.getDeclaringClass();

        QueryCondition qc = field.getAnnotation(QueryCondition.class);
        if (qc != null && null != qc.refField() && !"".equals(qc.refField())) {
            Field refField = findDeclaredField(beanClazz, qc.refField());
            return refField == null ? qc.refField() : getSqlColumnName(refField);
        }

        return field.getName();
    }

    /**
     * 搜索字段，包含私有的，从当前类开始搜索，如果当前类没有，继续往父类中查找，直到找到或到Object为止
     *
     * @param clazz     类对象
     * @param fieldName 属性名称
     * @return 属性对象
     */
    public static Field findDeclaredField(Class<?> clazz, String fieldName) {
        if (null == clazz || null == fieldName || "".equals(fieldName.trim())) {
            return null;
        }
        for (Class<?> superClass = clazz; superClass != Object.class; superClass = superClass.getSuperclass()) {
            try {
                return superClass.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                // ignored
            }
        }
        return null;
    }

    /**
     * Convert a name in camelCase to an underscored name in lower case.
     * Any upper case letters are converted to lower case with a preceding underscore.
     *
     * @param name the original name
     * @return the converted name
     * @see #lowerCaseName
     * @since 4.2
     */
    public static String underlineName(String name) {
        if (!StringUtils.hasLength(name)) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        result.append(lowerCaseName(name.substring(0, 1)));
        for (int i = 1; i < name.length(); i++) {
            String s = name.substring(i, i + 1);
            String slc = lowerCaseName(s);
            if (!s.equals(slc)) {
                result.append("_").append(slc);
            } else {
                result.append(s);
            }
        }
        return result.toString();
    }

    /**
     * Convert the given name to lower case.
     * By default, conversions will happen within the US locale.
     *
     * @param name the original name
     * @return the converted name
     * @since 4.2
     */
    public static String lowerCaseName(String name) {
        return name.toLowerCase(Locale.US);
    }

    /**
     * 是否是合法的查询条件属性
     *
     * @param field 查询属性
     * @return true 是， false 否
     */
    private static boolean isValidQueryConditionField(Field field) {
        QueryCondition qc = field.getAnnotation(QueryCondition.class);
        if (null == qc || qc.ignored()) {
            return false;
        }

        if (Modifier.isPrivate(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
            return true;
        }

        return false;
    }
}

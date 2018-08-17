package com.yemast.frame.core.util;

import java.util.Collection;

/**
 * 公共方法
 *
 * @author WangWx
 * @date 2018年08月17日 13:42
 */
public class CommonUtil {

    /**
     * 判断为空
     *
     * @param object
     * @return
     */
    public static boolean isEmpty(Object object) {
        boolean result = true;
        if (object == null) {
            return true;
        }
        if (object instanceof String) {
            result = (object.toString().trim().length() == 0) || object.toString().trim().equals("null");
        } else if (object instanceof Collection) {
            result = ((Collection<?>) object).size() == 0;
        } else {
            result = (object.toString().trim().length() < 1) ? true : false;
        }
        return result;
    }

    /**
     * 判断不为空
     *
     * @param object
     * @return
     */
    public static boolean isNotEmpty(Object object) {
        return !isEmpty(object);
    }

    /**
     * 判断两者是否相同(排除为空的情况)
     *
     * @param o1
     * @param o2
     * @return
     */
    public static boolean equals(Object o1, Object o2) {
        if (isAllNotEmpty(o1, o2)) {
            return o1.equals(o2);
        }
        return false;
    }

    /**
     * 判断都不为空
     *
     * @param object
     * @return
     */
    public static boolean isAllNotEmpty(Object... object) {
        boolean flag = true;
        for (Object o : object) {
            flag = isNotEmpty(o);
            if (!flag) {
                break;
            }
        }
        return flag;
    }

}

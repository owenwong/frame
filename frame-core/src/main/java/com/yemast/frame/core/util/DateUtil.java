package com.yemast.frame.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 *
 * @author WangWX
 * @date 2018/8/17 10:14
 */
public class DateUtil {

    private static final String DATE_HOUR = "h";

    /**
     * 格式化日期为字符串的函数
     *
     * @param date
     * @param format
     * @return java.lang.String
     */
    public static String formatDate(Date date, String format) {
        if (date == null) {
            return "";
        }
        if (format.indexOf(DATE_HOUR) > 0) {
            // 大写H是24小时制
            format = format.replace('h', 'H');
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }

    /**
     * 格式化日期
     *
     * @param date
     * @return java.lang.String
     */
    public static String formatDate(Date date) {
        return formatDate(date, "yyyy-MM-dd");
    }

    /**
     * 格式化日期
     *
     * @param date
     * @return java.lang.String
     */
    public static String formatDateTime(Date date) {
        return formatDate(date, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 将字符串（指定格式）转化为日期
     *
     * @param str
     * @param format
     * @return java.util.Date
     */
    public static Date parseDate(String str, String format) {
        try {
            if (CommonUtil.isEmpty(str)) {
                return null;
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
            return simpleDateFormat.parse(str);
        } catch (Exception e) {
            return new Date();
        }
    }

    /**
     * 把字符串日期解析成Date对象
     *
     * @param str
     * @return java.util.Date
     */
    public static Date parseDate(String str) {
        if ((str == null) || (str.trim().length() == 0)) {
            return null;
        }
        String format = "yyyy-MM-dd HH:mm:ss";
        switch (str.length()) {
            case 6:
                format = "yyyyMM";
                break;
            case 10:
                format = "yyyy-MM-dd";
                break;
            case 13:
                format = "yyyy-MM-dd HH";
                break;
            case 14:
                format = "yyyyMMddHHmmss";
                break;
            case 16:
                format = "yyyy-MM-dd HH:mm";
                break;
            case 21:
                format = "yyyy-MM-dd HH:mm:ss.S";
                break;
            default:
                break;
        }
        return parseDate(str, format);
    }
}

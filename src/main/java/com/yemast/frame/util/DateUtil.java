package com.yemast.frame.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author WangWx
 * @date 2018年08月16日 13:26
 */
public class DateUtil {

    /**
     * 格式化日期为字符串的函数.
     *
     * @param date   日期.
     * @param format 转换格式，如："yyyy-MM-dd HH:mm"。
     * @return 格式化后的日期字符串.
     */
    public static String formatDate(Date date, String format) {
        if (date == null) {
            return "";
        }
        if (format.indexOf("h") > 0) {
            format = format.replace('h', 'H'); // 大写H是24小时制
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }

    public static String formatDate(Date date) {
        return formatDate(date, "yyyy-MM-dd");
    }

    public static String formatDateTime(Date date) {
        return formatDate(date, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 将字符串（指定格式）转化为日期
     *
     * @param str    字符串.
     * @param format 转换格式如:"yyyy-MM-dd HH:mm"
     * @return 字符串包含的日期.
     */
    public static Date parseDate(String str, String format) {
        try {
            if ((str == null) || str.equals("")) {
                return null;
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
            return simpleDateFormat.parse(str);
        } catch (Exception e) {
        }
        return new Date();
    }

    /**
     * 把字符串日期解析成Date对象
     *
     * @param str 日期字符串，格式为以下几种中的一种。 yyyy-MM-dd, example 2004-08-26 yyyy-MM-dd HH,
     *            example 2004-08-26 12 yyyy-MM-dd HH:mm, example 2004-08-26 12:09
     *            yyyy-MM-dd HH:mm:ss, example 2004-08-26 12:09:08
     * @return Date对象
     */
    public static Date parseDate(String str) {
        if ((str == null) || (str.trim().length() == 0)) {
            return null;
        }
        switch (str.length()) {
            case 6:
                return parseDate(str, "yyyyMM");
            case 10:
                return parseDate(str, "yyyy-MM-dd");
            case 13:
                return parseDate(str, "yyyy-MM-dd HH");
            case 14:
                return parseDate(str, "yyyyMMddHHmmss");
            case 16:
                return parseDate(str, "yyyy-MM-dd HH:mm");
            case 19:
                return parseDate(str, "yyyy-MM-dd HH:mm:ss");
            case 21:
                return parseDate(str, "yyyy-MM-dd HH:mm:ss.S");
            default:
                return new Date();
        }
    }
}

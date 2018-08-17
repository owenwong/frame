package com.yemast.frame.core.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

/**
 * Json工具类
 *
 * @Author WangWX
 * @Date 2018/8/13 13:11
 */
public class JsonUtil {

    /**
     * JackSon对象
     */
    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * Object 转 Json
     *
     * @return java.lang.String
     * @Param [obj]
     */
    public static String o2j(Object obj) {
        try {
            return MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Json 转 Bean
     *
     * @return T
     * @Param [jsonStr, objClass]
     */
    public static <T> T json2Bean(String jsonStr, Class<T> objClass) {
        try {
            return MAPPER.readValue(jsonStr, objClass);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Json 转 List<T>
     *
     * @return java.util.List<T>
     * @Param [jsonData, beanType]
     */
    public static <T> List<T> jsonToList(String jsonData, Class<T> beanType) {
        JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
        try {
            List<T> list = MAPPER.readValue(jsonData, javaType);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

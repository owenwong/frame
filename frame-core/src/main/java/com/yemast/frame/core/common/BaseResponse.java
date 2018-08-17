package com.yemast.frame.core.common;

import com.yemast.frame.core.util.CommonUtil;
import com.yemast.frame.core.util.Const;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 基础响应数据
 *
 * @author WangWX
 * @date 2018/8/17 9:47
 */
@Data
public class BaseResponse {

    /**
     * 0-成功 1-失败
     */
    private Integer code;
    /**
     * 消息
     */
    private String msg;

    /***
     * 数据
     */
    private Object data;

    volatile private static BaseResponse baseResponse = null;

    public BaseResponse() {
    }

    public BaseResponse(Object data) {
        this.code = Const.SUCCESS;
        this.msg = "OK";
        this.data = data;
    }

    public BaseResponse(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static BaseResponse ok() {
        return new BaseResponse(null);
    }

    public static BaseResponse ok(Object data) {
        return new BaseResponse(data);
    }

    public BaseResponse setData(String name, Object data) {
        Map<String, Object> map = CommonUtil.isEmpty(this.data) ? new HashMap<>(16) : (Map<String, Object>) this.data;
        map.put(name, data);
        this.data = map;
        return this;
    }

    public static BaseResponse failToken(String msg) {
        return new BaseResponse(Const.FAIL_TOKEN, msg, null);
    }

    public static BaseResponse failArgument(String msg) {
        return new BaseResponse(Const.FAIL_ARGUMENT, msg, null);
    }

    public static BaseResponse failBusiness(String msg) {
        return new BaseResponse(Const.FAIL_BUSINESS, msg, null);
    }

    public static BaseResponse failRuntime(String msg) {
        return new BaseResponse(Const.FAIL_RUNTIME, msg, null);
    }

}

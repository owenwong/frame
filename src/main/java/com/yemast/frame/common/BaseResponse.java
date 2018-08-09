package com.yemast.frame.common;

import com.yemast.frame.util.Const;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author WangWx
 * @since 2018年08月07日 14:39
 */
public class BaseResponse {
    /**
     * 0-成功 1-失败
     */
    private String code;
    /**
     * 消息
     */
    private String msg;

    /***
     * 数据
     */
    private Object data;

    public BaseResponse() {
        setSuccess("成功");
    }

    public BaseResponse(String msg) {
        setSuccess(msg);
    }

    public String getCode() {
        return code;
    }

    private void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(String name, Object obj) {
        Map<String, Object> map = Objects.isNull(data) ? new HashMap<>(16) : (Map<String, Object>) data;
        map.put(name, obj);
        data = map;
    }

    public void setSuccess() {
        setCode(Const.SUCCESS);
    }

    public void setSuccess(String msg) {
        setCode(Const.SUCCESS);
        setMsg(msg);
    }

    public void setFail() {
        setCode(Const.FAIL);
    }

    public void setFail(String msg) {
        setCode(Const.FAIL);
        setMsg(msg);
    }

    public void systemError() {
        setFail("系统异常,请联系管理员");
    }

}

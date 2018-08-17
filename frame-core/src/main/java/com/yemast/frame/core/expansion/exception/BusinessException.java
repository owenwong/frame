package com.yemast.frame.core.expansion.exception;

/**
 * 自定义业务异常
 *
 * @Author WangWX
 * @Date 2018/8/13 13:10
 */
public class BusinessException extends RuntimeException {
    private String errCode = "9999";
    private static final long serialVersionUID = -1198192963458178630L;

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String errCode, String message) {
        super(message);
        this.errCode = errCode;
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable e) {
        super(message, e);
    }

    public BusinessException(String errCode, String message, Throwable e) {
        super(message, e);
        this.errCode = errCode;
    }

    public String getErrCode() {
        return this.errCode;
    }

}
package com.yemast.frame.expansion.exception;

import com.yemast.frame.common.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * 全局异常处理类
 *
 * @Author WangWX
 * @Date 2018/8/13 13:12
 */
@RestControllerAdvice
@Slf4j
public class GlobalJsonExceptionHandler {

    private static final String MESSAGE = "服务器开小差，请稍后再试...";

    /**
     * Exception 处理
     *
     * @return java.lang.Object
     * @Param [request, e]
     */
    @ExceptionHandler(value = Exception.class)
    public BaseResponse defaultErrorHandler(HttpServletRequest request, Exception e) {
        log.error(e.getLocalizedMessage(), e);
        BaseResponse response = new BaseResponse();
        response.setFail(MESSAGE);
        return response;
    }

    /**
     * 自定义异常处理
     *
     * @return java.lang.Object
     * @Param [request, e]
     */
    @ExceptionHandler(value = BusinessException.class)
    public BaseResponse myErrorHandler(HttpServletRequest request, BusinessException e) {
        log.error(e.getLocalizedMessage(), e);
        BaseResponse response = new BaseResponse();
        response.setFail(e.getLocalizedMessage());
        return response;
    }

    /**
     * 判断是否为Ajax请求
     *
     * @return boolean
     * @Param [request]
     */
    private static boolean isAjax(HttpServletRequest request) {
        return Objects.equals(request.getHeader("X-Requested-With"), "XMLHttpRequest");
    }

}
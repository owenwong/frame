package com.yemast.frame.expansion.exception;

import com.yemast.frame.common.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理类
 *
 * @author owen
 * @since 11:31
 */
//@RestControllerAdvice
@Slf4j
public class GlobalJsonException {

    @ExceptionHandler(value = Exception.class)
    public BaseResponse defaultErrorJsonHandler(HttpServletRequest request, Exception e) {
        BaseResponse response = new BaseResponse();
        response.setFail("服务器开小差，请稍后再试...");
        log.error(e.getLocalizedMessage(), e);
        return response;
    }

    @ExceptionHandler(value = BusinessException.class)
    public BaseResponse myErrorJsonHandler(HttpServletRequest request, BusinessException e) {
        BaseResponse response = new BaseResponse();
        response.setFail(e.getLocalizedMessage());
        log.error(e.getLocalizedMessage(), e);
        return response;
    }
}

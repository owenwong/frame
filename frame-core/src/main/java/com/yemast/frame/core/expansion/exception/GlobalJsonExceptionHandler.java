package com.yemast.frame.core.expansion.exception;

import com.yemast.frame.core.common.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 全局异常处理类
 *
 * @Author WangWX
 * @Date 2018/8/13 13:12
 */
@Slf4j
@RestControllerAdvice
public class GlobalJsonExceptionHandler {

    private static String MESSAGE = "服务器开小差，请稍后再试...";

    /**
     * Exception 处理
     *
     * @param request
     * @param e
     * @return com.yemast.frame.core.common.BaseResponse
     */
    @ExceptionHandler(value = Exception.class)
    public BaseResponse handlerException(HttpServletRequest request, Exception e) {
        log.error(e.getLocalizedMessage(), e);
        // 处理绑定异常 或 方法参数无效的
        if (e instanceof BindException) {
            BindException be = (BindException) e;
            return BaseResponse.failArgument(bulidMessage(be.getBindingResult()));
        }
        // 处理自定义业务异常
        else if (e instanceof BusinessException) {
            return BaseResponse.failBusiness(e.getLocalizedMessage());
        } else {
            return BaseResponse.failRuntime(MESSAGE);
        }
    }

    /**
     * 处理消息
     *
     * @param result
     * @return java.lang.String
     */
    public String bulidMessage(BindingResult result) {
        List<ObjectError> allErrors = result.getAllErrors();
        List<String> messages = new ArrayList<>();
        for (ObjectError error : allErrors) {
            // 转换异常特殊处理
            if (error.getDefaultMessage().contains("FormatException")) {
                Object[] object = error.getArguments();
                for (int i = 0; i < object.length; i++) {
                    DefaultMessageSourceResolvable dmsr = (DefaultMessageSourceResolvable) object[i];
                    messages.add(dmsr.getDefaultMessage() + "参数类型有误");
                }
            } else {
                messages.add(error.getDefaultMessage());
            }
        }
        return messages.stream().collect(Collectors.joining(","));
    }

    /**
     * 判断是否为Ajax请求
     *
     * @param request
     * @return boolean
     */
    private static boolean isAjax(HttpServletRequest request) {
        return Objects.equals(request.getHeader("X-Requested-With"), "XMLHttpRequest");
    }

}

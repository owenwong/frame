package com.yemast.frame.core.expansion.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理类
 *
 * @Author WangWX
 * @Date 2018/8/13 13:12
 */
@Slf4j
//@ControllerAdvice
public class GlobalViewExceptionHandler {

    private static final String MESSAGE = "服务器开小差，请稍后再试...";

    /**
     * Exception 处理
     *
     * @param request
     * @param e
     * @return org.springframework.web.servlet.ModelAndView
     */
    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception e) {
        log.error(e.getLocalizedMessage(), e);
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("exception", e);
        mv.addObject("url", request.getRequestURL());
        mv.addObject("message", MESSAGE);
        return mv;
    }

    /**
     *  自定义异常处理
     *
     * @param request
     * @param e
     * @return org.springframework.web.servlet.ModelAndView
     */
    @ExceptionHandler(value = BusinessException.class)
    public ModelAndView myErrorHandler(HttpServletRequest request, BusinessException e) {
        log.error(e.getLocalizedMessage(), e);
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("exception", e);
        mv.addObject("url", request.getRequestURL());
        mv.addObject("message", e.getLocalizedMessage());
        return mv;
    }

}

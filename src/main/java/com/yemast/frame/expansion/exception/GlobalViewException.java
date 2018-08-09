package com.yemast.frame.expansion.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理类
 *
 * @author owen
 * @since 11:31
 */
//@ControllerAdvice
@Slf4j
public class GlobalViewException {

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception e) {
        ModelAndView mav = new ModelAndView("error");
        mav.addObject("exception", e);
        mav.addObject("url", request.getRequestURL());
        mav.addObject("message", e.getLocalizedMessage());
        log.error(e.getLocalizedMessage(), e);
        return mav;
    }

}

package com.yemast.frame.core.expansion.aspect;

import com.yemast.frame.core.common.BaseResponse;
import com.yemast.frame.core.expansion.exception.BusinessException;
import com.yemast.frame.core.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 环绕拦截
 *
 * @author WangWX
 * @date 2018/8/13 13:07
 */
@Slf4j
//@Aspect
//@Component
public class AroundAspect {

    private static String MESSAGE = "服务器开小差，请稍后再试...";

    /**
     * 定义拦截规则：拦截com.yemast.frame包下面的所有类中，有@RequestMapping注解的方法。
     */
    @Pointcut("execution(public * com.yemast.frame..*(..)) && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void pointCut() {
    }

    /**
     * 拦截请求
     *
     * @param pjp
     * @return java.lang.Object
     */
    @Around("pointCut()")
    public Object Interceptor(ProceedingJoinPoint pjp) {
        BaseResponse baseResponse;
        try {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            long startTime = System.currentTimeMillis();
            log.info("请求地址:" + request.getRequestURL().toString());
            log.info("请求方法:" + pjp.getSignature().getName());
            log.info("请求参数:" + Arrays.asList(pjp.getArgs()));
            baseResponse = (BaseResponse) pjp.proceed(pjp.getArgs());
            log.info("响应数据:" + JsonUtil.o2j(baseResponse));
            log.info("响应耗时:" + ((System.currentTimeMillis() - startTime)) + "ms");
        } catch (Throwable throwable) {
            baseResponse = handlerException(pjp, throwable);
        }
        return baseResponse;
    }

    /**
     * 处理异常
     *
     * @param point
     * @param e
     * @return com.yemast.frame.core.common.BaseResponse
     */
    private BaseResponse handlerException(JoinPoint point, Throwable e) {
        log.error("请求方法:" + point.getSignature().getName());
        log.error("请求参数" + Arrays.asList(point.getArgs()));
        log.error("异常信息:" + e.getLocalizedMessage(), e);
        if (e instanceof BusinessException) {
            return BaseResponse.failBusiness(e.getLocalizedMessage());
        } else {
            return BaseResponse.failRuntime(MESSAGE);
        }
    }

}

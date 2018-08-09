package com.yemast.frame.expansion.aspect;

import com.yemast.frame.common.BaseResponse;
import com.yemast.frame.expansion.exception.BusinessException;
import com.yemast.frame.util.JsonUtil;
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
 * @author WangWx
 * @since 2018年08月07日 14:29
 */
//@Aspect
//@Component
@Slf4j
public class AroundAspect {

    /**
     * 定义拦截规则：拦截com.yemast.frame包下面的所有类中，有@RequestMapping注解的方法。
     */
    @Pointcut("execution(public * com.yemast.frame..*(..)) && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void pointCut() {
    }

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

    private BaseResponse handlerException(JoinPoint point, Throwable e) {
        log.error("请求方法:" + point.getSignature().getName());
        log.error("请求参数" + Arrays.asList(point.getArgs()));
        log.error("异常信息:" + e.getLocalizedMessage(), e);
        BaseResponse baseResponse = new BaseResponse();
        if (e instanceof BusinessException) {
            baseResponse.setFail(e.getLocalizedMessage());
        } else {
            baseResponse.setFail("服务器开小差，请稍后再试...");
        }
        return baseResponse;
    }

}

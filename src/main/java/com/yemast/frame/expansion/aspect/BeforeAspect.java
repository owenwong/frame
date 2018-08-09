package com.yemast.frame.expansion.aspect;

import com.yemast.frame.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.NamedThreadLocal;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author WangWx
 * @since 2018年08月07日 14:29
 */
@Aspect
@Component
@Slf4j
public class BeforeAspect {
    private static final ThreadLocal<Long> startTimeThreadLocal = new NamedThreadLocal<>("ThreadLocal StartTime");

    /**
     * 定义拦截规则：拦截com.yemast.frame包下面的所有类中，有@RequestMapping注解的方法。
     */
    @Pointcut("execution(public * com.yemast.frame..*(..)) && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void pointCut() {
    }

    /**
     * @author owen
     * @since 16:09
     */
    @Before("pointCut()")
    public void doBefore(JoinPoint jp) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        startTimeThreadLocal.set(System.currentTimeMillis());
        log.info("请求地址:" + request.getRequestURL().toString());
        log.info("请求方法:" + jp.getSignature().getName());
        log.info("请求参数:" + Arrays.asList(jp.getArgs()));
    }

    /**
     * @author owen
     * @since 8:44
     */
    @AfterReturning(pointcut = "pointCut()", returning = "object")
    public Object doAfter(Object object) {
        log.info("响应数据:" + JsonUtil.o2j(object));
        log.info("响应耗时:" + ((System.currentTimeMillis() - startTimeThreadLocal.get())) + "ms");
        return object;
    }

    /**
     * @author owen
     * @since 8:44
     */
//    @AfterThrowing(pointcut = "pointCut()", throwing = "e")
    public void doAfterThrowing(JoinPoint point, Throwable e) {
        log.error("请求方法:" + point.getSignature().getName());
        log.error("请求参数" + Arrays.asList(point.getArgs()));
        log.error("异常信息:" + e.getLocalizedMessage(), e);
    }

}

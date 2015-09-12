package com.baidu.unbiz.dsp.archtype.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * You may register aspect classes as regular beans in your Spring XML configuration, or autodetect them through
 * classpath scanning - just like any other Spring-managed bean. However, note that the @Aspect annotation is not
 * sufficient for autodetection in the classpath: For that purpose, you need to add a separate @Component annotation
 * (or alternatively a custom stereotype annotation that qualifies, as per the rules of Spring’s component scanner).
 * <p/>
 * http://docs.spring.io/spring/docs/4.1.7.RELEASE/spring-framework-reference/htmlsingle/#aop
 *
 * @author zhangxu
 */
@Component
@Aspect
public class ProfilingAspect {

    @Around("execution(* com.baidu.unbiz.dsp.archtype.service..*Impl.*(..))")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        StopWatch sw = new StopWatch(getClass().getSimpleName());
        try {
            sw.start(pjp.getSignature().getName());
            return pjp.proceed();
        } finally {
            sw.stop();
            System.out.println(sw.prettyPrint());
        }
    }

}

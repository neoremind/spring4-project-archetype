package com.baidu.unbiz.dsp.archtype.rpc;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author zhangxu
 */
public class RpcAdvisor implements MethodInterceptor {

    public Object invoke(MethodInvocation invocation) throws Throwable {
        Method m = invocation.getMethod();
        System.out.println("Calling " + m.getName());
        return invocation.proceed();
    }

}

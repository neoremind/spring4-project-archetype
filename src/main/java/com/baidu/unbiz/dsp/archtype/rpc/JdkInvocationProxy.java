package com.baidu.unbiz.dsp.archtype.rpc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author zhangxu
 */
public class JdkInvocationProxy implements InvocationHandler {

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        final Class<?> targetClass;
//        Method targetMethod;
//        Object[] targetArgs;
//
//        targetClass = method.getDeclaringClass();
//        targetMethod = method;
//        targetArgs = args;
//        System.out.println(String.format(
//                "Proxy bean start to invoke rpc class=%s, method=%s, args=%s",
//                targetClass.getName(), targetMethod, Arrays.toString(targetArgs)));

        return args == null ? 0 : args[0].hashCode();
    }

}

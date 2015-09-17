package com.baidu.unbiz.dsp.archtype.rpc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author zhangxu
 */
public class JdkDynamicProxyBuilder implements ProxyBuilder {

    /**
     * 代理handler
     */
    private InvocationHandler invocationHandler = new JdkInvocationProxy();

    public Object buildProxy(ClassLoader loader, Class<?> serviceInterface) {
        return Proxy.newProxyInstance(loader,
                new Class[] {serviceInterface}, invocationHandler);
    }

}

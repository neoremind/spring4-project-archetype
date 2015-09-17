package com.baidu.unbiz.dsp.archtype.rpc;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author zhangxu
 */
public class RemoteRpcCallProxyFactoryBean implements FactoryBean, InitializingBean {

    /**
     * 调用接口
     */
    private Class<?> serviceInterface;

    /**
     * 代理handler
     */
    private ProxyBuilder proxyBuilder;

    public Object getObject() throws Exception {
        return proxyBuilder.buildProxy(getClass().getClassLoader(), serviceInterface);
    }

    public Class<?> getObjectType() {
        return serviceInterface;
    }

    public boolean isSingleton() {
        return false;
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("Create proxy rpc bean " + getClass().getSimpleName() + " for interface "
                + serviceInterface);
    }

    public void setProxyBuilder(ProxyBuilder proxyBuilder) {
        this.proxyBuilder = proxyBuilder;
    }

    public void setServiceInterface(Class<?> serviceInterface) {
        this.serviceInterface = serviceInterface;
    }
}

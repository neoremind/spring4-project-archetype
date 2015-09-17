package com.baidu.unbiz.dsp.archtype.rpc;

/**
 * @author zhangxu
 */
public interface ProxyBuilder {

    Object buildProxy(ClassLoader loader, Class<?> serviceInterface);

}

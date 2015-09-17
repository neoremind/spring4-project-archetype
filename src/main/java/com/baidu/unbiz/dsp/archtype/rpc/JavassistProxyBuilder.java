package com.baidu.unbiz.dsp.archtype.rpc;

import java.util.concurrent.atomic.AtomicInteger;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtMethod;
import javassist.CtNewMethod;

/**
 * @author zhangxu
 */
public class JavassistProxyBuilder implements ProxyBuilder {

    private static AtomicInteger counter = new AtomicInteger(0);

    public Object buildProxy(ClassLoader loader, Class<?> serviceInterface) {
        try {
            ClassPool pool = ContainerClassPool.getDefault();
            CtClass proxy = pool.makeClass("Stub$" + counter.getAndIncrement());
            // CtClass proxy =pool.getAndRename(Stub.class.getName(), Stub.class.getName() + "$" +counter
            // .getAndIncrement());
            CtClass inter = pool.get(serviceInterface.getName());
            proxy.setInterfaces(new CtClass[] {inter});

            CtMethod[] methods = inter.getDeclaredMethods();

            for (int n = 0; n < methods.length; n++) {
                CtMethod method = methods[n];
                StringBuilder mbody = new StringBuilder();
                mbody.append("{");
                mbody.append("return new Integer($1.hashCode());");
                mbody.append("}");
                CtMethod m = CtNewMethod.make(method.getReturnType(), method.getName(), method.getParameterTypes(),
                        null,
                        mbody.toString(), proxy);
                proxy.addMethod(m);
            }

            CtConstructor cc = new CtConstructor(new CtClass[] {}, proxy);
            cc.setBody("{}");
            proxy.addConstructor(cc);

            Class clazz = proxy.toClass();
            return clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
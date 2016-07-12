package com.baidu.unbiz.dsp.archtype.jmx;

/**
 * http://docs.spring.io/autorepo/docs/spring/4.1.x/spring-framework-reference/html/jmx.html
 *
 * @author zhangxu
 */
public class MyJmxConfigurationImpl {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String show() {
        StringBuffer sb = new StringBuffer().append("currentTimeMs=").append(System.currentTimeMillis()).append(
                ", name=").append(name);
        System.out.println("show()=" + sb.toString());
        return sb.toString();
    }

}

package com.baidu.unbiz.dsp.jmx;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import mx4j.tools.adaptor.http.HttpAdaptor;

/**
 * @author zhangxu
 */
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class MyJmxTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    private HttpAdaptor httpAdaptor;

    @Test
    public void testJmx() throws Exception {
        httpAdaptor.start();
        System.in.read();
    }
}

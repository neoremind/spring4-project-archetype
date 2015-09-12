package com.baidu.unbiz.dsp.config;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.baidu.unbiz.dsp.archtype.config.AppConfig;
import com.baidu.unbiz.dsp.archtype.config.AppConfig2;

/**
 * @author zhangxu
 */
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class AppConfigTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    private AppConfig appConfig;

    @Autowired
    private AppConfig2 appConfig2;

    @Test
    public void testConfig() {
        System.out.println(appConfig.getUrl());
    }

    @Test
    public void testConfig2() {
        System.out.println(appConfig2.getKey());
    }

}

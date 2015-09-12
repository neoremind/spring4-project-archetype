package com.baidu.unbiz.dsp.config;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author zhangxu
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class YamlTest implements ApplicationContextAware {

    @Autowired
    @Qualifier("yamlProperties")
    private Properties yamlProperties;

    private ApplicationContext ctx;

    @Test
    public void testConfig() {
        //Map（不能直接注入@Autowired Map）
        //请参考 Map依赖注入（http://jinnianshilongnian.iteye.com/blog/1989379）
        Map<String, Object> yamlMap = ctx.getBean("yamlMap", Map.class);
        //需要snakeyaml 该功能是从spring-boot引入的
        Map<String, Object> env = (Map<String, Object>) yamlMap.get("env");
        Map<String, Object> one = (Map<String, Object>) env.get("one");
        Assert.assertEquals("neo", one.get("name"));

        List<Map<String, Object>> two = (List) env.get("two");
        Assert.assertEquals(1, two.get(0).get("a"));
        Assert.assertEquals("3", two.get(1).get("c"));

        Assert.assertEquals(null, env.get("three"));

        //Properties
        Assert.assertEquals("neo", yamlProperties.getProperty("env.one.name"));
        //getProperty如果返回的数据时非String的则返回null
        Assert.assertEquals(1, yamlProperties.get("env.two[0].a"));
        Assert.assertEquals("3", yamlProperties.getProperty("env.two[1].c"));
        Assert.assertEquals("", yamlProperties.getProperty("env.three"));
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }
}

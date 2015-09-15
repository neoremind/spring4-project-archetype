package com.baidu.unbiz.dsp.archtype.service.impl;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.baidu.unbiz.dsp.archtype.service.CarService;

/**
 * @author zhangxu
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class BeanInjectionTest {

    @Autowired
    private Map<String, CarService> map;

    @Test
    public void testMapInjection() {
        System.out.println(map);
    }

}

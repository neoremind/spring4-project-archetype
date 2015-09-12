package com.baidu.unbiz.dsp.archtype.service.impl;

import java.util.List;
import java.util.concurrent.Future;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.baidu.unbiz.dsp.archtype.config.AppConfig;
import com.baidu.unbiz.dsp.archtype.dto.Car;
import com.baidu.unbiz.dsp.archtype.service.CarService;
import com.google.common.collect.Lists;

/**
 * @author zhangxu
 */
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
@EnableAsync
public class CarServiceImplTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    private CarService carService;

    @Test
    public void testAdd() {
        Car car = carService.add(getValidCar());
        System.out.println(car);
    }

    @Test
    public void testAddCars() throws Exception {
        Future<List<Car>> future = carService.addCars(getValidCars());
        System.out.println("Invoke and get future");
        System.out.println(future.get());
    }

    private Car getValidCar() {
        return new Car("BMW", "LA1234", 5);
    }

    private List<Car> getValidCars() {
        return Lists.newArrayList(new Car("BMW", "LA1234", 5),
                new Car("Benz", "NYCuuu", 2),
                new Car("Chevrolet", "LA1234", 7));
    }

}

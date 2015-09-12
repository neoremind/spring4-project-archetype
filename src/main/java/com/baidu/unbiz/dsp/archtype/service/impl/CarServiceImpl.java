package com.baidu.unbiz.dsp.archtype.service.impl;

import java.util.List;
import java.util.concurrent.Future;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import com.baidu.unbiz.dsp.archtype.config.AppConfig2;
import com.baidu.unbiz.dsp.archtype.dto.Car;
import com.baidu.unbiz.dsp.archtype.service.CarService;

/**
 * @author zhangxu
 */
@Service
public class CarServiceImpl implements CarService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CarServiceImpl.class);

    @Resource
    private AppConfig2 config;

    public Car add(Car car) {
        LOGGER.info(config.getKey());
        LOGGER.info("execute add car...");
        return car;
    }

    @Async
    public Future<List<Car>> addCars(List<Car> cars) {
        // mock time-consuming ops
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LOGGER.info("execute add cars...");
        return new AsyncResult<List<Car>>(cars);
    }

    public void setConfig(AppConfig2 config) {
        this.config = config;
    }
}

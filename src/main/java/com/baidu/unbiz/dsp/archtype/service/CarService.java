package com.baidu.unbiz.dsp.archtype.service;

import java.util.List;
import java.util.concurrent.Future;

import com.baidu.unbiz.dsp.archtype.dto.Car;

/**
 * @author zhangxu
 */
public interface CarService {

    Car add(Car car);

    Future<List<Car>> addCars(List<Car> cars);

}

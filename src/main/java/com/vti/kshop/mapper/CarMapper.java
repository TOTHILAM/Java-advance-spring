package com.vti.kshop.mapper;

import com.vti.kshop.dto.CarDto;
import com.vti.kshop.entity.Car;
import com.vti.kshop.form.CarCreateForm;
import com.vti.kshop.form.CarUpdateForm;

public class CarMapper {
    public static Car map(CarCreateForm form) {
        var car = new Car();
        car.setLicensePlate(form.getLicensePlate());
        car.setRepairDate(form.getRepairDate());
        car.setCustomerName(form.getCustomerName());
        car.setCatalog(form.getCatalog());
        car.setCarMaker(form.getCarMaker());
        return car;
    }

    public static CarDto map(Car car) {
        var dto = new CarDto();
        dto.setId(car.getId());
        dto.setLicensePlate(car.getLicensePlate());
        dto.setRepairDate(car.getRepairDate());
        dto.setCustomerName(car.getCustomerName());
        dto.setCatalog(car.getCatalog());
        dto.setCarMaker(car.getCarMaker());
        return dto.withSelfRel();
    }

    public static void map(CarUpdateForm form, Car car) {
        car.setLicensePlate(form.getLicensePlate());
        car.setRepairDate(form.getRepairDate());
        car.setCustomerName(form.getCustomerName());
        car.setCatalog(form.getCatalog());
        car.setCarMaker(form.getCarMaker());
    }
}

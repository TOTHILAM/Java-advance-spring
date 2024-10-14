package com.vti.kshop.mapper;

import com.vti.kshop.dto.AccessoryDto;
import com.vti.kshop.entity.Accessory;
import com.vti.kshop.entity.Car;
import com.vti.kshop.form.AccessoryCreateform;
import com.vti.kshop.form.AccessoryUpdateform;
import com.vti.kshop.form.CarUpdateForm;

public class AccessoryMapper {
    public static Accessory map(AccessoryCreateform form) {
        var accessory = new Accessory();
        accessory.setName(form.getName());
        accessory.setPrice(form.getPrice());
        accessory.setStatusDamaged(form.getStatusDamaged());
        accessory.setRepairStatus(form.getRepairStatus());
        return accessory;
    }

    public static AccessoryDto map(Accessory accessory) {
        var dto = new AccessoryDto();
        dto.setId(accessory.getId());
        dto.setName(accessory.getName());
        dto.setPrice(accessory.getPrice());
        dto.setStatusDamaged(accessory.getStatusDamaged());
        dto.setRepairStatus(accessory.getRepairStatus());
        var car = accessory.getCar();
        dto.setLicensePlate(car.getLicensePlate());
        dto.setRepairDate(car.getRepairDate());
        return dto.withSelfRel();
    }

    public static void map(AccessoryUpdateform form, Accessory accessory) {
        accessory.setName(form.getName());
        accessory.setPrice(form.getPrice());
        accessory.setStatusDamaged(form.getStatusDamaged());
        accessory.setRepairStatus(form.getRepairStatus());
    }
}

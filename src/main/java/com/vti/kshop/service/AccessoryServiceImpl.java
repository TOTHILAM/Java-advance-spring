package com.vti.kshop.service;

import com.vti.kshop.dto.AccessoryDto;
import com.vti.kshop.entity.Accessory;
import com.vti.kshop.form.AccessoryCreateform;
import com.vti.kshop.form.AccessoryUpdateform;
import com.vti.kshop.mapper.AccessoryMapper;
import com.vti.kshop.mapper.CarMapper;
import com.vti.kshop.repository.AccessoryRepository;
import com.vti.kshop.repository.CarRepository;
import jakarta.persistence.Access;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccessoryServiceImpl implements AccessoryService{
    private AccessoryRepository accessoryRepository;
    private CarRepository carRepository;

    @Override
    public Page<AccessoryDto> findAll(Pageable pageable) {
        return accessoryRepository.findAll(pageable)
                .map(AccessoryMapper::map);
    }

    @Override
    public AccessoryDto findById(Long id) {
        return accessoryRepository.findById(id)
                .map(AccessoryMapper::map)
                .orElse(null);
    }

    @Override
    public AccessoryDto create(AccessoryCreateform form) {
        var car = carRepository.findByLicensePlateAndRepairDate(form.getLicensePlate(), form.getRepairDate());
        if (car == null) return null;
        var accessory = AccessoryMapper.map(form);
        accessory.setCar(car);
        var savedAccessory = accessoryRepository.save(accessory);
        return AccessoryMapper.map(savedAccessory);
    }

    @Override
    public AccessoryDto update(Long id, AccessoryUpdateform form) {
        var optional = accessoryRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }
        var accessory = optional.get();
        AccessoryMapper.map(form, accessory);
        var savedAccessory = accessoryRepository.save(accessory);
        return AccessoryMapper.map(savedAccessory);
    }

    @Override
    public void deleteById(Long id) {
        accessoryRepository.deleteById(id);
    }
}

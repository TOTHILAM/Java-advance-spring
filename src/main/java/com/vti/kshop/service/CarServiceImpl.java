package com.vti.kshop.service;

import com.vti.kshop.dto.CarDto;
import com.vti.kshop.form.CarCreateForm;
import com.vti.kshop.form.CarUpdateForm;
import com.vti.kshop.mapper.CarMapper;
import com.vti.kshop.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarServiceImpl implements CarService{
    private CarRepository carRepository;

    @Override
    public Page<CarDto> findAll(Pageable pageable) {
        return carRepository.findAll(pageable)
                .map(CarMapper::map);
    }

    @Override
    public CarDto findById(Long id) {
        return carRepository.findById(id)
                .map(CarMapper::map)
                .orElse(null);
    }

    @Override
    public CarDto create(CarCreateForm form) {
        var car = CarMapper.map(form);
        var savedCar =carRepository.save(car);
        return CarMapper.map(savedCar);
    }

    @Override
    public CarDto update(Long id, CarUpdateForm form) {
        var optional = carRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }
        var car = optional.get();
        CarMapper.map(form, car);
        var savedCar = carRepository.save(car);
        return CarMapper.map(savedCar);
    }

    @Override
    public void deleteById(Long id) {
        carRepository.deleteById(id);
    }
}

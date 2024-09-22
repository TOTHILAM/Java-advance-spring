package com.vti.kshop.service;

import com.vti.kshop.dto.CarDto;
import com.vti.kshop.form.CarCreateForm;
import com.vti.kshop.form.CarUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CarService {
    Page<CarDto> findAll(Pageable pageable);

    CarDto findById(Long id);

    CarDto create(CarCreateForm form);

    CarDto update(Long id, CarUpdateForm form);

    void deleteById(Long id);
}

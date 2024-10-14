package com.vti.kshop.validation;

import com.vti.kshop.repository.CarRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CarIdExistsValidator
        implements ConstraintValidator<CarIdExists, Long> {
    private CarRepository carRepository;

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext context) {
        return carRepository.existsById(id);
    }
}

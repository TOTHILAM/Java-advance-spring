package com.vti.kshop.controller;

import com.vti.kshop.dto.CarDto;
import com.vti.kshop.form.CarCreateForm;
import com.vti.kshop.form.CarUpdateForm;
import com.vti.kshop.service.CarService;
import com.vti.kshop.validation.CarIdExists;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@AllArgsConstructor
@CrossOrigin("http://127.0.0.1:5500/")
public class CarController {
    private CarService carService;

    @GetMapping("/api/v1/cars")
    public Page<CarDto> findAll(Pageable pageable) {
        return carService.findAll(pageable);
    }

    @PostMapping("/api/v1/cars")
    @ResponseStatus(HttpStatus.CREATED)
    public CarDto create(@RequestBody @Valid CarCreateForm form) {
        return carService.create(form);
    }

    @GetMapping("/api/v1/cars/{id}")
    public CarDto findById(@PathVariable("id") @CarIdExists Long id) {
        return carService.findById(id);
    }

    @PutMapping("/api/v1/cars/{id}")
    public CarDto update(@PathVariable("id") @CarIdExists Long id, @RequestBody @Valid CarUpdateForm form) {
        return carService.update(id, form);
    }

    @DeleteMapping("/api/v1/cars/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") @CarIdExists Long id) {
        carService.deleteById(id);
    }
}

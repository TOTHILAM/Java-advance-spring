package com.vti.kshop.repository;


import com.vti.kshop.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface CarRepository extends JpaRepository<Car, Long> {
    Car findByLicensePlateAndRepairDate(String licencePlate, LocalDate repairDate);
}

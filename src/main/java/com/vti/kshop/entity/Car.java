package com.vti.kshop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "car")
public class Car {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "license_plate", length = 10, nullable = false)
    private String licensePlate;

    @Column(name = "repair_date", nullable = false)
    private LocalDate repairDate;

    @Column(name = "customer_name", length = 50, nullable = false)
    private String customerName;

    @Column(name = "catalog", length = 50, nullable = false)
    private String catalog;

    @Column(name = "car_maker", length = 50, nullable = false)
    private String carMaker;
}

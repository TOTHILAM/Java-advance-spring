package com.vti.kshop.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CarDto {
    private Long id;
    private String licensePlate;
    private LocalDate repairDate;
    private String customerName;
    private String catalog;
    private String carMaker;
}

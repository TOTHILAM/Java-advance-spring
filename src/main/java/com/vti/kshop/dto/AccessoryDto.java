package com.vti.kshop.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AccessoryDto {
    private Long id;
    private String name;
    private Long price;
    private String statusDamaged;
    private String repairStatus;
    private String licensePlate;
    private LocalDate repairDate;
}

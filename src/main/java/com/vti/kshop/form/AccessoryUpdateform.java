package com.vti.kshop.form;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AccessoryUpdateform {
    private String name;
    private Long price;
    private String statusDamaged;
    private String repairStatus;
    private String licensePlate;
    private LocalDate repairDate;
}

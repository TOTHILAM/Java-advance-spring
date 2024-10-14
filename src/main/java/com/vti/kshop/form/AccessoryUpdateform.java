package com.vti.kshop.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Getter
@Setter
public class AccessoryUpdateform {
    @NotBlank(message = "Accessory name must not be blank")
    @Length(max = 50, message = "Accessory name has max 50 characters")
    private String name;

    @NotNull(message = "Accessory price must not be null")
    @PositiveOrZero(message = "Accessory price must be positive or zero")
    private Long price;

    @NotBlank(message = "Accessory status damaged must not be blank")
    @Length(max = 50, message = "Accessory status damaged has max 50 characters")
    private String statusDamaged;

    @NotBlank(message = "Accessory repair status must not be blank")
    @Length(max = 50, message = "Accessory repair status has max 50 characters")
    private String repairStatus;

    @NotBlank(message = "Car license plate must not be blank")
    @Length(max = 10, message = "Car license plate has max 10 characters")
    private String licensePlate;

    @NotNull(message = "Car repair date must not be null")
    @PastOrPresent(message = "Car repair date must be past or present")
    private LocalDate repairDate;
}

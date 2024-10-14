package com.vti.kshop.dto;

import com.vti.kshop.controller.CarController;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Getter
@Setter
public class CarDto extends RepresentationModel<CarDto> {
    private Long id;
    private String licensePlate;
    private LocalDate repairDate;
    private String customerName;
    private String catalog;
    private String carMaker;

    public CarDto withSelfRel() {
        var controller = methodOn(CarController.class);
        var dto = controller.findById(id);
        var link = linkTo(dto).withSelfRel();
        return add(link);
    }
}

package com.vti.kshop.dto;

import com.vti.kshop.controller.AccessoryController;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Getter
@Setter
public class AccessoryDto extends RepresentationModel<AccessoryDto> {
    private Long id;
    private String name;
    private Long price;
    private String statusDamaged;
    private String repairStatus;
    private String licensePlate;
    private LocalDate repairDate;

    public AccessoryDto withSelfRel() {
        var controller = methodOn(AccessoryController.class);
        var dto = controller.findById(id);
        var link = linkTo(dto).withSelfRel();
        return add(link);
    }
}

package com.vti.springframework.dto;

import com.vti.springframework.controller.CommentController;
import com.vti.springframework.controller.PostController;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;

import static java.awt.AWTEventMulticaster.add;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Getter
@Setter
public class CommentDto extends RepresentationModel<CommentDto> {
    private Long id;
    private String name;
    private String email;
    private String body;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public CommentDto withSelRel() {
        var controller = methodOn(CommentController.class);
        var dto = controller.findById(id);
        var link = linkTo(dto).withSelfRel();
        return add(link);
    }
}

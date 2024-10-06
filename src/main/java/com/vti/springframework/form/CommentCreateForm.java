package com.vti.springframework.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class CommentCreateForm {
    @NotBlank(message = "Comment name must not be blank")
    @Length(max = 50, message = "Comment name has max 50 characters")
    private String name;

    @NotBlank(message = "Comment email must not be blank")
    @Length(max = 75, message = "Comment email has max 75 characters")
    @Email(message = "Comment email is invalid")
    private String email;

    @NotBlank(message = "Comment body must not be blank")
    @Length(max = 100, message = "Comment body has max 100 characters")
    private String body;
}

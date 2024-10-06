package com.vti.springframework.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class PostCreateForm {
    @NotBlank(message = "{post.title.NotBlank.message}")
    @Length(max = 50, message = "{post.title.Length.message}")
    private  String title;

    @NotBlank(message = "Post description must not be blank")
    @Length(max = 100, message = "Post description has max 100 characters")
    private String description;

    @NotBlank(message = "Post content must not be blank")
    @Length(max = 150, message = "Post content has max 150 characters")
    private String content;
}

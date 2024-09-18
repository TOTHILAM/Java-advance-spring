package com.vti.springframework.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostCreateForm {
    private  String title;
    private String description;
    private String content;
}

package com.vti.springframework.form;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class PostFilterForm {
    private String search;
    private LocalDate minCreateDate;
    private LocalDate maxCreateDate;
}

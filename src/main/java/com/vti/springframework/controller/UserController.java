package com.vti.springframework.controller;

import com.vti.springframework.dto.UserDto;
import com.vti.springframework.form.UserCreateForm;
import com.vti.springframework.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/v1/users")
    public UserDto create(@RequestBody @Valid UserCreateForm form) {
        return userService.create(form);
    }
}

package com.vti.springframework.service;

import com.vti.springframework.dto.UserDto;
import com.vti.springframework.form.UserCreateForm;

public interface UserService {
    UserDto create(UserCreateForm form);
}

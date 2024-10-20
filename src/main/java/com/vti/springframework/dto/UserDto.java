package com.vti.springframework.dto;

import com.vti.springframework.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class UserDto {
    private Long id;
    private String name;
    private String username;
    private String email;
    private String password;
    private User.Role role;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

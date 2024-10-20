package com.vti.springframework.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class UserCreateForm {
    @NotBlank(message = "User name must not be blank")
    @Length(max = 50, message = "User name has max 50 characters")
    private String name;

    @NotBlank(message = "User username must not be blank")
    @Length(max = 50, message = "User username has max 50 characters")
    private String username;

    @NotBlank(message = "User email must not be blank")
    @Length(max = 50, message = "User email has max 50 characters")
    @Email(message = "User email is not valid")
    private String email;

    @NotBlank(message = "User password must not be blank")
    @Length(
            min = 6, max = 12,
            message = "User password length must between 6 and 12"
    )
    private String password;

    @Pattern(
            regexp = "ADMIN|EMPLOYEE|MANAGER",
            message = "User role must be ADMIN, EMPLOYEE or MANAGER"
    )
    private String role;
}

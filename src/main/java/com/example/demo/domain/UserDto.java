package com.example.demo.domain;

import com.example.demo.validation.ValidEmail;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UserDto {
    @NotNull
    @NotEmpty(message = "{message.badCredentials}")
    private String firstName;

    @NotNull
    @NotEmpty
    private String lastName;

    @NotNull
    @NotEmpty
    private String password;
    private String matchingPassword;

    @NotNull
    @NotEmpty
    @ValidEmail(message = "{message.badCredentials}")
    private String email;

    // standard getters and setters
}

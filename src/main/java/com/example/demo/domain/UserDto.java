package com.example.demo.domain;

import com.example.demo.validation.FieldsMatches;
import com.example.demo.validation.ValidEmail;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@FieldsMatches.List({
        @FieldsMatches(field = "password", fieldMatch = "matchingPassword"),
        @FieldsMatches(field = "firstName", fieldMatch = "lastName"),
})
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
    @ValidEmail
    private String email;

    // standard getters and setters
}

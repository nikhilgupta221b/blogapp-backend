package com.nikhil.blogapp.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private int id;

    @NotBlank
    @Size(min = 2, message = "Name should have minimum 4 characters!")
    private String name;

    @Email(message = "Email should be valid!")
    private String email;

    @NotBlank
    @Size(min = 5, message = "Password should have minimum 5 characters!")
    private String password;

    @NotBlank(message = "About can't be blank!")
    private String about;
}

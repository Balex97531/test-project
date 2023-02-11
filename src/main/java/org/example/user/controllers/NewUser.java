package org.example.user.controllers;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;



@AllArgsConstructor
@Getter
public class NewUser {
    @NotBlank(message = "The name is required")
    private String name;
    @NotBlank(message = "The email is required")
    @Email
    private String email;
    @NotBlank(message = "The password is required")
    private String password;

}

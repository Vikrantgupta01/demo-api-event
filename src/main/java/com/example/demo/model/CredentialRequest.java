package com.example.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
public class CredentialRequest {

    private static final String PASSWORD_REGEX = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$";

    @NotBlank(message = "Email is mandatory")
    @Email
    private String email;

    @NotBlank(message = "Password is mandatory")
    @Pattern(regexp = PASSWORD_REGEX, message = "Password must be between length of 8-20 character with atleast one special character and capital letter")
    private String password;

    @NotBlank(message = "Confirm Password is mandatory")
    @Pattern(regexp = PASSWORD_REGEX, message = "Password must be between length of 8-20 character with atleast one special character and capital letter")
    private String confirmPassword;

}

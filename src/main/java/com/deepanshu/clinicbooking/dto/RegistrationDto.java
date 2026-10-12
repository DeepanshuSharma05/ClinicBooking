package com.deepanshu.clinicbooking.dto;

import lombok.*;
import jakarta.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor    // Generates a constructor with 0 arguments
@AllArgsConstructor
@Builder
public class RegistrationDto {

    @NotBlank(message = " Role Cannot be null")
    private String role;

    @NotBlank(message = " name Cannot be null")
    private String name;

    @NotBlank(message = " email Cannot be null")
    private String email;

    @NotBlank(message = " contact Cannot be null")
    private String contact;

    @NotBlank(message = " state Cannot be null")
    private String state;

    @NotBlank(message = " city Cannot be null")
    private String city;

    @NotBlank(message = "pincode Cannot be null")
    private String pincode;

    @NotBlank(message = "Password cannot be null")
    private String password;

}

package com.farmdigital.nerddevs.Registration.Dto;


import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.validator.constraints.Length;


@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class FarmerRegistrationDto {
    @NotBlank(message = "name cannot be empty")
    private  String name;
    private  String  email=null;
    @Pattern(regexp = "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$",
            message = "password must contain least 8 character with an upper case , a special" +
                    " character(!,@,$,&,%) and a number ")
    private  String  password;
    @NotBlank(message = "phone number is a requirement in order to continue with your registration")
    @Length(max = 12,min = 10)
    private  String  phoneNumber;

//check everything


}

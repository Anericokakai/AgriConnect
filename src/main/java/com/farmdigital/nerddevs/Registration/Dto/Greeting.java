package com.farmdigital.nerddevs.Registration.Dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter

public class Greeting {
    private String  password;
    private String  confirmPassword;
}

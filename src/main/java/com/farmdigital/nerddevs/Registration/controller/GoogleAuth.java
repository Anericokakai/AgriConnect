package com.farmdigital.nerddevs.Registration.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController

public class GoogleAuth {
    @GetMapping
    public String google(){
        return "welcome to google auth";
    }

    @GetMapping("/user/auth/google")
    public Principal user(Principal principal){
        System.out.println(principal.getName());
        return principal;

    }
}

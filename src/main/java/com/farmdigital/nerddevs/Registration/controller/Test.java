package com.farmdigital.nerddevs.Registration.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/farm_digital/user")
public class Test {
    @GetMapping
    public  String  test() {
    return "hello from secure api";
    }

}

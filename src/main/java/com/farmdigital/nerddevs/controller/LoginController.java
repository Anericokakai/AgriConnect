package com.farmdigital.nerddevs.controller;
import com.farmdigital.nerddevs.Dto.UserRegistrationDto;
import com.farmdigital.nerddevs.service.UserRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor

@RequestMapping("/api/v1/farm_digital/super")
public class LoginController {

    private  final UserRegistrationService userRegistrationService;

    @GetMapping("/user")
    public String  findUser(){
        return "anerico";
    }
    @PostMapping("/super")
    public ResponseEntity<?> registerUse(@RequestBody UserRegistrationDto user){
        String  res= userRegistrationService.saveUer(user);

//
return  ResponseEntity.status(HttpStatus.CREATED).body(res);
    }
}
package com.farmdigital.nerddevs.Registration.controller;
import com.farmdigital.nerddevs.Registration.Dto.AuthenticationDto;
import com.farmdigital.nerddevs.Registration.Dto.FarmerRegistrationDto;
import com.farmdigital.nerddevs.Registration.Dto.Greeting;
import com.farmdigital.nerddevs.Registration.Dto.ResetPasswordDto;
import com.farmdigital.nerddevs.Registration.service.UserRegistrationService;
import com.farmdigital.nerddevs.Registration.views.ExceptionMessage;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.net.URI;

@RestController
@RequiredArgsConstructor

@RequestMapping("/api/v1/agri_connect/super")
public class FarmerAuthenticationController {
    private  final UserRegistrationService userRegistrationService;
private final  ExceptionMessage exceptionMessage;
//    ! add user route
    @PostMapping("/user/register")
    public ResponseEntity<?> registerUse(@RequestBody @Valid FarmerRegistrationDto user) throws Exception{
        var  res= userRegistrationService.saveUser(user);
//1233
    return  ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

//    ! login user
    @PostMapping("/user/authenticate")

    public  ResponseEntity<?> authenticateUser(@RequestBody @Valid AuthenticationDto request){

var response=userRegistrationService.authenticateauser(request);

        return  ResponseEntity.status(HttpStatus.OK).body(response);
    }
// ! forgot password route
    @PostMapping("/user/forgot_password")
    public  ResponseEntity<?> forgotPassword(@RequestBody @Valid ResetPasswordDto resetPasswordDto){
        var message= userRegistrationService.forgotPassword(resetPasswordDto.getEmail());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(message);
    }



//   ! reset password
    @PostMapping("/user/forgot_password/reset")
    public Object resetPasswordSubmit(@ModelAttribute Greeting greeting, Model model, @RequestParam("token") String  token){
        try{
            System.out.println(token);
            System.out.println(greeting.getPassword());
            System.out.println(greeting.getConfirmPassword());
            ModelAndView modelAndView= new ModelAndView();
            userRegistrationService.resetPassword(greeting.getPassword(),token);
            modelAndView.setViewName("reply");
            return modelAndView;
        } catch (Exception ex){

            if(ex instanceof ExpiredJwtException) {
                String  reason=" your token has expired , please request for another email in order to change your password .Remember that the link expires in in 20 minutes ";
                return exceptionMessage.sendBackError(reason) ;
            }

        }

        return "invalid token";
    }


}

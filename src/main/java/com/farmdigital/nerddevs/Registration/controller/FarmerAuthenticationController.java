package com.farmdigital.nerddevs.Registration.controller;
import com.farmdigital.nerddevs.Registration.Dto.AuthenticationDto;
import com.farmdigital.nerddevs.Registration.Dto.FarmerRegistrationDto;
import com.farmdigital.nerddevs.Registration.Dto.Greeting;
import com.farmdigital.nerddevs.Registration.Dto.ResetPasswordDto;
import com.farmdigital.nerddevs.Registration.service.UserRegistrationService;
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

@RequestMapping("/api/v1/farm_digital/super")
public class FarmerAuthenticationController {
    private  final UserRegistrationService userRegistrationService;

//    ! add user route
    @PostMapping("/user/register")
    public ResponseEntity<?> registerUse(@RequestBody @Valid FarmerRegistrationDto user) throws Exception{
        var  res= userRegistrationService.saveUser(user);
//1233
    return  ResponseEntity.status(HttpStatus.CREATED).body(res);
    }
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

    @PutMapping("/user/forgot_password/reset")
    public  ResponseEntity<?> PasswordReset(@RequestParam("password")String  password,@RequestParam("token")String token){

        var message=userRegistrationService.resetPassword(password,token);
        URI uri=URI.create("/login");
        return ResponseEntity.created(uri).body(message);

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
            return "<h2>an error occurred while changing  your password<.h2> " +
                    "<p>this could be due to some reasons one being your link has expired </p> " +ex.getMessage();

        }

    }


}

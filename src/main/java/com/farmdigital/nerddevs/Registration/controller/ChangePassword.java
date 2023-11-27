package com.farmdigital.nerddevs.Registration.controller;

import com.farmdigital.nerddevs.Registration.Dto.Greeting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/agri_connect/super")
public class ChangePassword {
    @GetMapping("/user/forgot_password/reset")
    public  String  resetPasswordForm(Model model){
        model.addAttribute("greeting", new Greeting());
        return "resetPassword";

    }


}

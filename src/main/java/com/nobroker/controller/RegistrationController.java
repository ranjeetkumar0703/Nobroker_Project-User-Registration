package com.nobroker.controller;

import com.nobroker.entity.User;
import com.nobroker.service.EmailService;
import com.nobroker.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/api")
public class RegistrationController {

    private UserService userService;
    private EmailService emailService;

    public RegistrationController(UserService userService, EmailService emailService) {
        this.userService = userService;
        this.emailService = emailService;
    }

    //http://localhost:8080/api/register
    @PostMapping("/register")
    public Map<String,String>registerUser(@RequestBody User user){
        User registeredUser=userService.registerUser(user);
        return emailService.sendOtpEmail(user.getEmail());


    }

}

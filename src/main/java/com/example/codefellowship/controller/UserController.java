package com.example.codefellowship.controller;

import com.example.codefellowship.service.UserSecurityDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UserController {
    @Autowired
    UserSecurityDetailsService userSecurityDetailsService;

    @GetMapping("/signup")
    public String getSignUpPage() {
        return "signup.html";
    }

    @GetMapping("/login")
    public String getSignInPage() {
        return "signin.html";
    }

    @PostMapping("/signup")
    public RedirectView signUp(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        userSecurityDetailsService.addUser(username, password);
        return new RedirectView("/login");
    }
}

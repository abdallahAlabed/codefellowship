package com.example.codefellowship.controller;

import com.example.codefellowship.model.Users;
import com.example.codefellowship.repository.UserRepository;
import com.example.codefellowship.service.UserSecurityDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.Date;

@Controller
public class UserController {
    @Autowired
    UserSecurityDetailsService userSecurityDetailsService;

    @GetMapping("/signup")
    public String getSignUpPage() {

        return "signup.html";
    }
    @GetMapping("/")
    public String getAllUsers() {

        return "users.html";
    }

    @GetMapping("/login")
    public String getSignInPage() {

        return "signin.html";
    }

    @PostMapping("/signup")
    public RedirectView signUp(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password,@RequestParam(value="userRole") String userRole,@RequestParam(value="bio") String bio,@RequestParam(value="dateOfBirth") String dateOfBirth,@RequestParam(value="firstName") String firstName,@RequestParam(value="lastName") String lastName) {
        userSecurityDetailsService.addUser(username, password,userRole,dateOfBirth,bio,firstName,lastName);
        return new RedirectView("/myprofile");
    }


    @PostMapping("/follow/{id}")
    public RedirectView followUser(Principal p, @PathVariable("id") Integer id){
        userSecurityDetailsService.follow(id,p);
        return  new RedirectView("/users/"+id);
    }
}

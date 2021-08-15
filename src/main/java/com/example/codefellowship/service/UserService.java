package com.example.codefellowship.service;

import com.example.codefellowship.model.User;
import com.example.codefellowship.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public void addUser(String username, String password) {
        User newUser = new User(username, bCryptPasswordEncoder.encode(password));
        userRepository.save(newUser);
    }


}

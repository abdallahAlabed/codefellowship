package com.example.codefellowship.service;

import com.example.codefellowship.repository.UserRepository;

import com.example.codefellowship.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class UserSecurityDetailsService implements UserDetailsService {


    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public void addUser(String username, String password) {
        Users newUser = new Users(username, bCryptPasswordEncoder.encode(password));
        userRepository.save(newUser);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users applicationUser = (Users) userRepository.findByUsername(username);

        if (applicationUser == null) {
            assert applicationUser != null;
            throw new UsernameNotFoundException("The user " + applicationUser.getUsername() + " does not exist");
        }
        return (UserDetails) applicationUser;
    }

}
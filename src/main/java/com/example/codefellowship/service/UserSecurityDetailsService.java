package com.example.codefellowship.service;

import com.example.codefellowship.model.UserRole;
import com.example.codefellowship.repository.UserRepository;

import com.example.codefellowship.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.security.Principal;
import java.util.Date;

@Service
public class UserSecurityDetailsService implements UserDetailsService {


    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    public void addUser(String username, String password, String userRole, String dateOfBirth,String bio,String firstName,String lastName) {
        System.out.println("******************************************************");
//        if (UserRole.valueOf("ROLE_USER").toString() ==userRole || UserRole.valueOf("ROLE_ADMIN").toString() ==userRole ){
        Users newUser = new Users(username, bCryptPasswordEncoder.encode(password), UserRole.valueOf(userRole),dateOfBirth,bio,firstName,lastName);
            System.out.println("--------------------------------------------------------------------");
        userRepository.save(newUser);
//        }
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users applicationUser = (Users) userRepository.findByUsername(username);

        if (applicationUser == null) {
            assert applicationUser != null;
            throw new UsernameNotFoundException("The user " + username + " does not exist");
        }
        return (UserDetails) applicationUser;
    }
    public void follow(Integer id, Principal p){
        Users following = userRepository.findById(id).get();
        Users follower = userRepository.findByUsername(p.getName());
        follower.addFollowing(following);
        userRepository.save(follower);
    }



}
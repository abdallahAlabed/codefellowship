package com.example.codefellowship.security;

import com.example.codefellowship.repository.UserRepository;

import com.example.codefellowship.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class UserSecurityDetailsService implements UserDetailsService {



        @Autowired
        UserRepository userRepository;

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            User applicationUser = (User) userRepository.findByUsername(username);

            if(applicationUser == null){
                assert applicationUser != null;
                throw  new UsernameNotFoundException("The user "+ applicationUser.getUsername() + " does not exist");
            }
            return (UserDetails) applicationUser;
        }

}
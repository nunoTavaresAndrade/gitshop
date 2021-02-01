package com.gitshop.gitshop.controllers;

import com.gitshop.gitshop.models.User;
import com.gitshop.gitshop.models.UserRole;
import com.gitshop.gitshop.repositories.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Controller
public class RegisterController {

    private static final Logger LOG = LoggerFactory.getLogger(RegisterController.class);

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/signup")
    public String register_view() {
        return "auth/form-signup";
    }

 
    @PostMapping("/signup")
    public String newRegister(
        @RequestParam(name = "username", required = true, defaultValue = "") String username,
        @RequestParam(name = "password", required = true, defaultValue = "") String password,
        @RequestParam(name = "role", required = true, defaultValue="") String role,
        Model UserModel){

             // save user data in database
             UserRole userRole = role.equalsIgnoreCase("Admin") ? UserRole.ADMIN : UserRole.USER;

           BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
           String encodedPassword = bcryptPasswordEncoder.encode(password);

            userRepository.save(new User(username, encodedPassword, userRole));

            LOG.info("custumers found with findAll():");
            LOG.info("-------------------------------");
            for (User user : userRepository.findAll()) {
                LOG.info(user.toString());
            }
    
            
           UserModel.addAttribute("username", username);
           UserModel.addAttribute("password", encodedPassword);
           UserModel.addAttribute("role", role);
           

        return "index";

    }

}
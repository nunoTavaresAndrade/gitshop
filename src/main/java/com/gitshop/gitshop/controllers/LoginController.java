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
class LoginController {
    
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String loginView(Model model) {
        return "auth/form-login";
    }

    @PostMapping("/login")
    public String login(
        @RequestParam(name = "username", required = true, defaultValue = "") String username,
        @RequestParam(name = "password", required = true, defaultValue = "") String password,
        Model UserModel){

            User user = userRepository.findByUsername(username);
            if (user == null) {
                System.out.println("user not found");
            }else{
                if(validatelLogin(user, password))
                    System.out.println("login done");
               
            }



           return "auth/login";

        }


        public boolean validatelLogin(User user, String password){
            BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = bcryptPasswordEncoder.encode(password);
            return user.getPassword().equals(encodedPassword);
        }



}
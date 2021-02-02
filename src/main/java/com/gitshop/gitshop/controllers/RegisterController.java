package com.gitshop.gitshop.controllers;

import com.gitshop.gitshop.models.User;
import com.gitshop.gitshop.models.UserRole;

import com.gitshop.gitshop.services.UserService;
import com.gitshop.gitshop.utils.AuthValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class RegisterController {

    private static final Logger LOG = LoggerFactory.getLogger(RegisterController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private AuthValidator authValidator;

    @GetMapping(value = {"/signup", "/signup?error"})
    public String register_view(Model model) {

        return "auth/form-signup";
    }






    @PostMapping("/signup")
    public String newRegister(@RequestParam(
            name = "username", defaultValue = "") String username,
            @RequestParam(name = "password") String password,
            @RequestParam(name = "role") String role, Model model) {


        UserRole userRole = role.equalsIgnoreCase("Admin") ?
                    UserRole.ADMIN : UserRole.USER;
        User user = new User(username, password,userRole);

        if(!authValidator.formValidate(user)) {
            model.addAttribute("alert_msg" , "user name mast have more them 6 characters \n and password length mast be greater then 8");
            return register_view(model);
        }


        if(authValidator.userExist(user)){
            LOG.info("user exists");
            return register_view(model);
        }

        userService.save(user);
        LOG.info(userService.findByUsername(username).toString());



        return "index";

    }





}
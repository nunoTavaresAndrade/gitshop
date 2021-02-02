package com.gitshop.gitshop.utils;

import com.gitshop.gitshop.models.User;
import com.gitshop.gitshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthValidator {
    @Autowired
    private UserService userService;

    public boolean formValidate(User user) {
        if (user.getUsername().length() < 6 || user.getUsername().length() > 24)
            return false;

        return user.getPassword().length() >= 8 && user.getPassword().length() <= 32;
    }

    public  boolean userExist(User user){
        return  userService.findByUsername(user.getUsername()) != null;
    }

}

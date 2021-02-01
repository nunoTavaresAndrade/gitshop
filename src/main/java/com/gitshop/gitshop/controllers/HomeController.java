package com.gitshop.gitshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = { "", "/", "home" })
    public String homeView() {
        return "index";
    }

}
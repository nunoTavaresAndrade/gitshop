package com.gitshop.gitshop.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);

    public HomeController() {
    }


    public  String homePage(Model model) {


        model.addAttribute("login", "logout");

        return "index";
    }


    @GetMapping("/advanced_search")
    public String advancedsearchPage() {
        return "advanced_search";
    }


    @GetMapping("/products")
    public  String productsPage() {
        return "products";
    }

}
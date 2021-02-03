package com.gitshop.gitshop.controllers;

import com.gitshop.gitshop.models.Product;
import com.gitshop.gitshop.services.product.ProductService;
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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    ProductService productService;

    public HomeController() {
    }


    @GetMapping(value = {"/home", "/"})
    public  String homePage(
            @RequestParam(name ="categorie", required = false, defaultValue = "html5")
            String categorie,
            @RequestParam(name ="search", required = false)String search,
            Model model) {

        List<Product> productList =  null;

        if(search!=null) {
            productList = productService.findProductByKeyWord(search);
            model.addAttribute("products", productList);
            model.addAttribute("categorie", "");
            model.addAttribute("length", productList.size());
            return "index";
        }

        productList = productService.findAllByCategorie(categorie);
        model.addAttribute("products", productList);
        model.addAttribute("categorie", categorie);
        model.addAttribute("length", productList.size());


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
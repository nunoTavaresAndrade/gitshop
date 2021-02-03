package com.gitshop.gitshop.controllers;


import com.gitshop.gitshop.models.Product;
import com.gitshop.gitshop.repositories.ProductRepository;
import com.gitshop.gitshop.services.product.ProductService;
import com.gitshop.gitshop.services.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductsController {
    private static final Logger LOG = LoggerFactory.getLogger(ProductsController.class);

    @Autowired
    private ProductService productService;


    // getting create product view
    @GetMapping(value = {"/products/create"})
    public String register_view(Model model) {

        return "products/form-create-product";
    }


    // create a product
    @PostMapping("/products/create")
    public String newProduct(
            @RequestParam(name = "name") String title,
            @RequestParam(name = "description") String description,
            @RequestParam(name = "categories") String categorie,
            @RequestParam(name = "price") String price,
            @RequestParam(name = "imgsrc") String imgSrc,
            Model model) {

        Product product = new Product(title, description, imgSrc, categorie,
                Float.parseFloat(price));

        productService.save(product);

        List<Product> productList = productService.findAll();

        model.addAttribute("produts", productList);

        return "redirect:/products/list";

    }


    // list all products
    @GetMapping("/products/list")
    public String listAllProduct(
            @RequestParam(name="search", required = false)String search,
            Model model) {


        List<Product> productList =  null;

        if(search!=null) {
            productList = productService.findProductByKeyWord(search);

            model.addAttribute("products", productList);

            return "products/list-products-view";
        }

        productList =  productService.findAll();

        model.addAttribute("products", productList);

        return "products/list-products-view";

    }



    // remove a product and redirect to list  products
    @GetMapping("/products/remove")
    public String removeProduct(@RequestParam(name = "id") String id, Model model) {

        LOG.info("id " + model.getAttribute("id"));

        try {

            long idParsed = Long.parseLong(id);

            productService.deleteById(idParsed);

        } catch (Exception e) {
            LOG.error("wrong id");
        }


        return "redirect:/products/list";
    }


}

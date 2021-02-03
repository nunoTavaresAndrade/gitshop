package com.gitshop.gitshop.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("index.html");
		registry.addViewController("/").setViewName("index.html");
		registry.addViewController("/products").setViewName("products.html");
		registry.addViewController("/advanced_search").setViewName("advanced_search.html");
		registry.addViewController("/login").setViewName("form-login.html");
		registry.addViewController("/singup").setViewName("form-signup.html");
		registry.addViewController("/products/create").setViewName("form-create-product.html");
		registry.addViewController("/products/list").setViewName("list-products-view.html");
		registry.addViewController("/products/remove").setViewName("list-products-view.html");


	}




}

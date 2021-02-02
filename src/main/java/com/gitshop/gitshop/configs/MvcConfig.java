package com.gitshop.gitshop.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("index");
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/products").setViewName("products");
		registry.addViewController("/advanced_search").setViewName("advanced_search.html");
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/singup").setViewName("singup");
	}

}

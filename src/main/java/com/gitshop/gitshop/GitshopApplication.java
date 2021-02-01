package com.gitshop.gitshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.gitshop.gitshop"})
public class GitshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(GitshopApplication.class, args);
	}

}

package com.grupp1.grupp1javaee.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("Home");
        registry.addViewController("/home").setViewName("Home");
        registry.addViewController("/login").setViewName("Login");

        registry.addViewController("/index").setViewName("Index");
        registry.addViewController("/new").setViewName("Addproduct");
        registry.addViewController("/edit/{id}").setViewName("Editproduct");



        registry.addViewController("/users").setViewName("AllUsers");
        registry.addViewController("/newUser").setViewName("AddUser");
        registry.addViewController("/editUser/{id}").setViewName("EditUser");



        // NEW DEMONSTRATION VIEWS
        registry.addViewController("/account").setViewName("account");
        registry.addViewController("/admin").setViewName("admin");
    }


}

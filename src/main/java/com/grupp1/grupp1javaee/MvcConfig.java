package com.grupp1.grupp1javaee;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/kundvagn").setViewName("Index");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("login");

        // NEW DEMONSTRATION VIEWS
        registry.addViewController("/account").setViewName("account");
        registry.addViewController("/admin").setViewName("admin");
    }


}

package com.grupp1.grupp1javaee;

import com.grupp1.grupp1javaee.Service.GroceryService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Grupp1JavaEeApplication {


    public static void main(String[] args) {
        SpringApplication.run(Grupp1JavaEeApplication.class, args);

        productService productService = new productService();



    }




}

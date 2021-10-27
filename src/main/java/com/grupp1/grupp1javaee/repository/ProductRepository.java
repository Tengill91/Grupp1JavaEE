package com.grupp1.grupp1javaee.repository;

import com.grupp1.grupp1javaee.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

// hämtar jpa repository som innehåller alla crud operationer productModel = vår klass och Integer är för vårat id i productModel klassen
public interface ProductRepository extends JpaRepository<Product, Integer> {
}

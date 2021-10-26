package com.grupp1.grupp1javaee;

import org.springframework.data.jpa.repository.JpaRepository;

// hämtar jpa repository som innehåller alla crud operationer productModel = vår klass och Integer är för vårat id i productModel klassen
public interface productRepository extends JpaRepository<productModel, Integer> {
}

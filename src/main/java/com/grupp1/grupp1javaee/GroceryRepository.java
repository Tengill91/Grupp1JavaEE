package com.grupp1.grupp1javaee;

import org.springframework.data.jpa.repository.JpaRepository;

// hämtar jpa repository som innehåller alla crud operationer GroceryModel = vår klass och Integer är för vårat id i GroceryModel klassen
public interface GroceryRepository extends JpaRepository<GroceryModel, Integer> {
}

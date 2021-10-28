package com.grupp1.grupp1javaee.Repository;

import com.grupp1.grupp1javaee.Model.GroceryModel;
import org.springframework.data.jpa.repository.JpaRepository;

<<<<<<< HEAD:src/main/java/com/grupp1/grupp1javaee/productRepository.java
// hämtar jpa repository som innehåller alla crud operationer productModel = vår klass och Integer är för vårat id i productModel klassen
public interface productRepository extends JpaRepository<productModel, Integer> {
=======
// hämtar jpa repository som innehåller alla crud operationer GroceryModel = vår klass och Integer är för vårat id i GroceryModel klassen
public interface GroceryRepository extends JpaRepository<GroceryModel, Integer> {

>>>>>>> a9f222b927e5a8e1484da1216aa93099b4ceefe3:src/main/java/com/grupp1/grupp1javaee/Repository/GroceryRepository.java
}

package com.grupp1.grupp1javaee.service;

import com.grupp1.grupp1javaee.model.Product;
import com.grupp1.grupp1javaee.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    // injektar in repository så vi slipper skapa ett objekt utav den för att få använda dess crud operationer
    @Autowired
    ProductRepository productRepository;


    // metoder (crud)


    // skriv ut alla matvaror
    public List<Product> getMYproductsS(){

        List<Product> productListS = productRepository.findAll();

        return productListS;

    }

    public int countAllproducts(){

        int totalSum=0;

        List<Product> productList = getMYproductsS();
        for(Product gm: productList) {
            totalSum += (gm.getPrice() * gm.getAmount() );
        }
        return totalSum;
    }

    // hitta efter id
    public Product getproductByIdS(int id){

        return productRepository.findById(id).get();
    }

    // save product
    public Product saveproductS (Product product){

        productRepository.save(product);

        return getproductByIdS(product.getId());
    }

    // delete product
    public void deleteproductS(int id){
        productRepository.deleteById(id);


    }

    public Product updadeproductS(Product product){

        productRepository.save(product);

        return product;

    }


}

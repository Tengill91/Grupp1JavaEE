package com.grupp1.grupp1javaee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class productService {

    // injektar in repository så vi slipper skapa ett objekt utav den för att få använda dess crud operationer
    @Autowired
    productRepository productRepository;


    // metoder (crud)


    // skriv ut alla matvaror
    public List<productModel> getMYproductsS(){

        List<productModel> productListS = productRepository.findAll();

        return productListS;

    }

    public int countAllproducts(){

        int totalSum=0;

        List<productModel> productList = getMYproductsS();
        for(productModel gm: productList) {
            totalSum += (gm.price * gm.amount );
        }
        return totalSum;
    }

    // hitta efter id
    public productModel getproductByIdS(int id){

        return productRepository.findById(id).get();
    }

    // save product
    public productModel saveproductS (productModel productModel){

        productRepository.save(productModel);

        return getproductByIdS(productModel.getId());
    }

    // delete product
    public void deleteproductS(int id){
        productRepository.deleteById(id);


    }

    public productModel updadeproductS(productModel productModel){

        productRepository.save(productModel);

        return productModel;

    }


}

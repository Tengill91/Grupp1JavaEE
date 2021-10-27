package com.grupp1.grupp1javaee.controller;

import com.grupp1.grupp1javaee.model.Product;
import com.grupp1.grupp1javaee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
// sätter start url
@RequestMapping("/")
public class ProductController {

    // injektar in productService för den har dom färdiga metoderna i sig
    @Autowired
    ProductService productservice;

    // kanske ska döpa om productListHTML attributename till getAllproductsHTML

    @RequestMapping(path="/index",method = RequestMethod.GET)
    private String getAllproducts(Model model) {
        List<Product> productList = productservice.getMYproductsS();
        int totalCost = productservice.countAllproducts();
        // Thymeleaf behöver ett namn för att länka in metoden till Html documentet
        model.addAttribute("productListHTML", productList);
        model.addAttribute("totalCostHtml", totalCost);
        return "Index";
    }


    @RequestMapping("/new")
    public String showNewproductPage(Model model) {
        // skapar ett nytt tomt objekt
        Product product = new Product();
        //Viktigt productModel objektet blir en del utav editproductHtml namnet
        // (man använder alltså editproductHtml för att komma åt productModel objektets variabler)
        model.addAttribute("productModelHTML", product);
        // länkar till Addproduct.html
        return "Addproduct";
    }

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public String saveproduct(@ModelAttribute("productModel") Product productmodel) {
        productservice.saveproductS(productmodel);
        return "redirect:/index";

    }

    @GetMapping("/edit/{id}")
    private String editproduct(@PathVariable("id") int id, Model model) {
        Product product = productservice.getproductByIdS(id);
        model.addAttribute("editproductHtml", product);
        return "Editproduct";

    }

    @RequestMapping(path = "/update/{id}", method = RequestMethod.POST)
    private String updateproduct(@PathVariable("id") int id, @ModelAttribute Product product) {
        product.setId(id);
        productservice.updadeproductS(product);
        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    private String deleteproduct(@PathVariable("id") int id) {
        productservice.deleteproductS(id);
        return "redirect:/index";
    }


}
package com.grupp1.grupp1javaee;

import org.hibernate.annotations.common.reflection.XMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
// sätter start url
@RequestMapping("/")
public class productController {

    // injektar in productService för den har dom färdiga metoderna i sig
    @Autowired
    productService productservice;

    // kanske ska döpa om productListHTML attributename till getAllproductsHTML

    @RequestMapping(path="/index",method = RequestMethod.GET)
    private String getAllproducts(Model model) {
        List<productModel> productList = productservice.getMYproductsS();
        int totalCost = productservice.countAllproducts();
        // Thymeleaf behöver ett namn för att länka in metoden till Html documentet
        model.addAttribute("productListHTML", productList);
        model.addAttribute("totalCostHtml", totalCost);
        return "Index";
    }


    @RequestMapping("/new")
    public String showNewproductPage(Model model) {
        // skapar ett nytt tomt objekt
        productModel productModel = new productModel();
        //Viktigt productModel objektet blir en del utav editproductHtml namnet
        // (man använder alltså editproductHtml för att komma åt productModel objektets variabler)
        model.addAttribute("productModelHTML", productModel);
        // länkar till Addproduct.html
        return "Addproduct";
    }

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public String saveproduct(@ModelAttribute("productModel") productModel productmodel) {
        productservice.saveproductS(productmodel);
        return "redirect:/index";

    }

    @GetMapping("/edit/{id}")
    private String editproduct(@PathVariable("id") int id, Model model) {
        productModel productModel = productservice.getproductByIdS(id);
        model.addAttribute("editproductHtml", productModel);
        return "Editproduct";

    }

    @RequestMapping(path = "/update/{id}", method = RequestMethod.POST)
    private String updateproduct(@PathVariable("id") int id, @ModelAttribute productModel productModel) {
        productModel.setId(id);
        productservice.updadeproductS(productModel);
        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    private String deleteproduct(@PathVariable("id") int id) {
        productservice.deleteproductS(id);
        return "redirect:/index";
    }


}
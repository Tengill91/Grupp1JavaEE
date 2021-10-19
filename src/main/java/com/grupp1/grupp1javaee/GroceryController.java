package com.grupp1.grupp1javaee;

import org.hibernate.annotations.common.reflection.XMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
// sätter start url
@RequestMapping("/")
public class GroceryController {

    // injektar in GroceryService för den har dom färdiga metoderna i sig
    @Autowired
    GroceryService groceryservice;

    // kanske ska döpa om groceryListHTML attributename till getAllGrocerysHTML

@RequestMapping(method = RequestMethod.GET)
    private String getAllGrocerys(Model model){
    List<GroceryModel> groceryList = groceryservice.getMYGrocerysS();
    // Thymeleaf behöver ett namn för att länka in metoden till Html documentet
    model.addAttribute("groceryListHTML",groceryList);
    return "Index";
    }


    @RequestMapping("/new")
    public String showNewGroceryPage(Model model){
    // skapar ett nytt tomt objekt
    GroceryModel groceryModel= new GroceryModel();
    // Ger ett namn till metoden. som vi sedan ska skriva in i AddGrocery.html
    // och lägger till objektet groceryModel
    model.addAttribute("groceryModelHTML",groceryModel);
    // länkar till AddGrocery.html
    return "AddGrocery";
    }

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public String saveGrocery (@ModelAttribute("groceryModel") GroceryModel grocerymodel){
    groceryservice.saveGroceryS(grocerymodel);
    return "redirect:/";

    }










}
package com.grupp1.grupp1javaee.Controller;

import com.grupp1.grupp1javaee.Model.GroceryModel;
import com.grupp1.grupp1javaee.Service.GroceryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
// sätter start url

public class GroceryController {

    // injektar in GroceryService för den har dom färdiga metoderna i sig
    @Autowired
    GroceryService groceryservice;

    // kanske ska döpa om groceryListHTML attributename till getAllGrocerysHTML

@RequestMapping(path= "/index",method = RequestMethod.GET)
    private String getAllGrocerys(Model model){
    List<GroceryModel> groceryList = groceryservice.getMYGrocerysS();
    int totalCost = groceryservice.countAllGrocerys();
    // Thymeleaf behöver ett namn för att länka in metoden till Html documentet
    model.addAttribute("groceryListHTML",groceryList);
    model.addAttribute("totalCostHtml",totalCost);
    return "Index";
    }


    @RequestMapping(path = "/new")
    public String showNewGroceryPage(Model model){
    // skapar ett nytt tomt objekt
    GroceryModel groceryModel= new GroceryModel();
    //Viktigt groceryModel objektet blir en del utav editGroceryHtml namnet
        // (man använder alltså editGroceryHtml för att komma åt groceryModel objektets variabler)
    model.addAttribute("groceryModelHTML",groceryModel);
    // länkar till AddGrocery.html
    return "AddGrocery";
    }

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public String saveGrocery (@ModelAttribute("groceryModel") GroceryModel grocerymodel){
    groceryservice.saveGroceryS(grocerymodel);
    return "redirect:/index";

    }

    @GetMapping("/edit/{id}")
    private String editGrocery(@PathVariable("id") int id, Model model){
        GroceryModel groceryModel = groceryservice.getGroceryByIdS(id);
        model.addAttribute("editGroceryHtml", groceryModel);
        return "EditGrocery";

    }

    @RequestMapping(path = "/update/{id}", method = RequestMethod.POST)
    private String updateGrocery(@PathVariable("id") int id, @ModelAttribute GroceryModel groceryModel){
    groceryModel.setGrocery_id(id);
    groceryservice.updadeGroceryS(groceryModel);
    return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    private String deleteGrocery(@PathVariable("id") int id) {
        groceryservice.deleteGroceryS(id);
        return "redirect:/index";
    }










}
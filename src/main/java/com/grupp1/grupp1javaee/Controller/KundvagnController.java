package com.grupp1.grupp1javaee.Controller;

import com.grupp1.grupp1javaee.Model.GroceryModel;
import com.grupp1.grupp1javaee.Model.KundvagnModel;
import com.grupp1.grupp1javaee.Service.KundvagnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class KundvagnController {

    @Autowired
    KundvagnService kundvagnService;

    @RequestMapping(path= "/kundvagn",method = RequestMethod.GET)
    private String getAllGrocerys(Model model){
        List<KundvagnModel> kundvagnModelList = kundvagnService.getMYGrocerysS();
        int totalCost = kundvagnService.countAllKundvagnGrocerys();
        // Thymeleaf behöver ett namn för att länka in metoden till Html documentet
        model.addAttribute("KundvagnListHTML",kundvagnModelList);
        model.addAttribute("totalCostHtml",totalCost);
        return "Kundvagn";
    }


    @RequestMapping(path = "/newKundvagnGrocery")
    public String showNewGroceryPage(Model model){
        // skapar ett nytt tomt objekt
        KundvagnModel kundvagnModel= new KundvagnModel();
        //Viktigt groceryModel objektet blir en del utav editGroceryHtml namnet
        // (man använder alltså editGroceryHtml för att komma åt groceryModel objektets variabler)
        model.addAttribute("kundvagnGroceryHTML",kundvagnModel);
        // länkar till AddGrocery.html
        return "AddKundvagnGrocery";
    }

    @RequestMapping(path = "/saveKundvagn", method = RequestMethod.POST)
    public String saveGrocery (@ModelAttribute("groceryModel") KundvagnModel kundvagnModel){
        kundvagnService.saveKundvagnGroceryS(kundvagnModel);
        return "redirect:/kundvagn";

    }
//-------------
    @GetMapping("/editKundvagnGrocery/{id}")
    private String editGrocery(@PathVariable("id") int id, Model model){
        KundvagnModel kundvagnModel = kundvagnService.getKundvagnGroceryByIdS(id);
        model.addAttribute("editKundvagnGroceryHtml", kundvagnModel);
        return "EditKundvagnGrocery";

    }

    @RequestMapping(path = "/updateKundvagn/{id}", method = RequestMethod.POST)
    private String updateGrocery(@PathVariable("id") int id, @ModelAttribute KundvagnModel kundvagnModel){
        kundvagnModel.setKundvagn_id(id);
        kundvagnService.updadeKundvagnGroceryS(kundvagnModel);
        return "redirect:/kundvagn";
    }

    @GetMapping("/deleteKundvagnGrocery/{id}")
    private String deleteGrocery(@PathVariable("id") int id) {
        kundvagnService.deleteKundvagnGroceryS(id);
        return "redirect:/kundvagn";
    }

}

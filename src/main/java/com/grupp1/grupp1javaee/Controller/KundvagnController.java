package com.grupp1.grupp1javaee.Controller;

import com.grupp1.grupp1javaee.Model.GroceryModel;
import com.grupp1.grupp1javaee.Model.KundvagnModel;
import com.grupp1.grupp1javaee.Service.KundvagnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

}

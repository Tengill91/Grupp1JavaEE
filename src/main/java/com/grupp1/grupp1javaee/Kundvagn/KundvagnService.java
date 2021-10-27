package com.grupp1.grupp1javaee.Kundvagn;

import com.grupp1.grupp1javaee.Grocery.GroceryModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class KundvagnService {

    @Autowired
    KundvagnRepository kundvagnRepository;


    /*public List<GroceryModel> getMYGrocerysS() {

        List<GroceryModel> groceryListS = kundvagnRepository.findAllById(2);
        return groceryListS;
    }*/


}

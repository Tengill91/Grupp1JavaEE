package com.grupp1.grupp1javaee.Service;

import com.grupp1.grupp1javaee.Repository.KundvagnRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class KundvagnService {

    @Autowired
    KundvagnRepository kundvagnRepository;


    /*public List<GroceryModel> getMYGrocerysS() {

        List<GroceryModel> groceryListS = kundvagnRepository.findAllById(2);
        return groceryListS;
    }*/


}

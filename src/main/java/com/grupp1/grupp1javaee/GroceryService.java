package com.grupp1.grupp1javaee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceryService {

    // injektar in repository så vi slipper skapa ett objekt utav den för att få använda dess crud operationer
    @Autowired
    GroceryRepository groceryRepository;


    // metoder (crud)


    // skriv ut alla matvaror
    public List<GroceryModel> getMYGrocerysS(){

        List<GroceryModel> groceryListS = groceryRepository.findAll();

        return groceryListS;

    }

    // hitta efter id
    public GroceryModel getGroceryByIdS(int id){

        return groceryRepository.findById(id).get();
    }

    // save grocery
    public GroceryModel saveGroceryS (GroceryModel groceryModel){

        groceryRepository.save(groceryModel);

        return getGroceryByIdS(groceryModel.getId());
    }

    // delete grocery
    public void deleteGroceryS(int id){
        groceryRepository.deleteById(id);


    }

    public GroceryModel updadeGroceryS(GroceryModel groceryModel){

        groceryRepository.save(groceryModel);

        return groceryModel;

    }


}

package com.grupp1.grupp1javaee.Grocery;

import com.grupp1.grupp1javaee.Grocery.GroceryModel;
import com.grupp1.grupp1javaee.Grocery.GroceryRepository;
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

    public int countAllGrocerys(){

        int totalSum=0;

        List<GroceryModel> groceryList = getMYGrocerysS();
        for(GroceryModel gm: groceryList) {
            totalSum += (gm.getPrice() * gm.getAmount() );
        }
        return totalSum;
    }

    // hitta efter id
    public GroceryModel getGroceryByIdS(int id){

        return groceryRepository.findById(id).get();
    }

    // save grocery
    public GroceryModel saveGroceryS (GroceryModel groceryModel){

        groceryRepository.save(groceryModel);

        return getGroceryByIdS(groceryModel.getGrocery_id());
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

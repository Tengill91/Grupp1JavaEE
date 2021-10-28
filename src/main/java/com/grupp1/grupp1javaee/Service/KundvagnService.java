package com.grupp1.grupp1javaee.Service;

import com.grupp1.grupp1javaee.Model.GroceryModel;
import com.grupp1.grupp1javaee.Model.KundvagnModel;
import com.grupp1.grupp1javaee.Repository.GroceryRepository;
import com.grupp1.grupp1javaee.Repository.KundvagnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KundvagnService {

    @Autowired
    KundvagnRepository kundvagnRepository;

    @Autowired
    GroceryRepository groceryRepository;


    public List<KundvagnModel> getMYGrocerysS(){

        List<KundvagnModel> groceryListS = kundvagnRepository.findAll();

        String loggedInUser;

        Object principal = SecurityContextHolder. getContext(). getAuthentication(). getPrincipal();
        if (principal instanceof UserDetails) {
            loggedInUser = ((UserDetails)principal). getUsername();
        } else {
            loggedInUser = principal. toString();
        }

        List<KundvagnModel> sortedGroceryListS = groceryListS.stream().filter(u -> u.getUser_name().equals(loggedInUser)).collect(Collectors.toList());

        return sortedGroceryListS;

    }


    public int countAllKundvagnGrocerys(){

        int totalSum=0;

        List<KundvagnModel> groceryList = getMYGrocerysS();
        for(KundvagnModel km: groceryList) {
            totalSum += (km.getPrice() * km.getAmount() );
        }
        return totalSum;
    }


    /*public List<GroceryModel> getMYGrocerysS() {

        List<GroceryModel> groceryListS = kundvagnRepository.findAllById(2);
        return groceryListS;
    }*/


}

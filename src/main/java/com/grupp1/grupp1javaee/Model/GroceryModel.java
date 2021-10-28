package com.grupp1.grupp1javaee.Model;

import com.grupp1.grupp1javaee.Service.KundvagnService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
// skapar ett table i våran databas och lägger in de objekt som den här klassen skapar i det tablet
@Table(name = "grocery_list")
public class GroceryModel {



    @Id
    // autogenererar id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int grocery_id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    private UserModel owner;


    private String name;
    private int price;
    private int amount;

    public GroceryModel() {
    }

    public GroceryModel(int grocery_id, UserModel owner, String name, int price, int amount) {
        this.grocery_id = grocery_id;
        this.owner = owner;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public int getGrocery_id() {
        return grocery_id;
    }

    public void setGrocery_id(int grocery_id) {
        this.grocery_id = grocery_id;
    }

    public UserModel getOwner() {
        return owner;
    }

    public void setOwner(UserModel owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "GroceryModel{" +
                "grocery_id=" + grocery_id +
                ", owner=" + owner +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}



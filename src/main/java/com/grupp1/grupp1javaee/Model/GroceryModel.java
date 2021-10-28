package com.grupp1.grupp1javaee.Model;

import javax.persistence.*;

@Entity
// skapar ett table i våran databas och lägger in de objekt som den här klassen skapar i det tablet
<<<<<<< HEAD:src/main/java/com/grupp1/grupp1javaee/productModel.java
@Table(name = "product")
public class productModel {

    @Id
    // autogenererar id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
=======
@Table(name = "grocery_list")
public class GroceryModel {

    @Id
    // autogenererar id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int grocery_id;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    private UserModel owner;
>>>>>>> a9f222b927e5a8e1484da1216aa93099b4ceefe3:src/main/java/com/grupp1/grupp1javaee/Model/GroceryModel.java


    private String name;
    private int price;
    private int amount;

    public productModel() {
    }

<<<<<<< HEAD:src/main/java/com/grupp1/grupp1javaee/productModel.java
    public productModel(int id, String name, int price, int amount) {
        this.id = id;
=======
    public GroceryModel(int grocery_id, UserModel owner, String name, int price, int amount) {
        this.grocery_id = grocery_id;
        this.owner = owner;
>>>>>>> a9f222b927e5a8e1484da1216aa93099b4ceefe3:src/main/java/com/grupp1/grupp1javaee/Model/GroceryModel.java
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
<<<<<<< HEAD:src/main/java/com/grupp1/grupp1javaee/productModel.java
        return "productModel{" +
                "id=" + id +
=======
        return "GroceryModel{" +
                "grocery_id=" + grocery_id +
                ", owner=" + owner +
>>>>>>> a9f222b927e5a8e1484da1216aa93099b4ceefe3:src/main/java/com/grupp1/grupp1javaee/Model/GroceryModel.java
                ", name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}



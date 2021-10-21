package com.grupp1.grupp1javaee;

import javax.persistence.*;

@Entity
// skapar ett table i våran databas och lägger in de objekt som den här klassen skapar i det tablet
@Table(name = "kundvagn")
public class GroceryModel {

    @Id
    // autogenererar id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;
    int price;
    int amount;

    public GroceryModel() {
    }

    public GroceryModel(int id, String name, int price, int amount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}

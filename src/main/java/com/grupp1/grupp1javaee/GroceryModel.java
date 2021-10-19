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

    // tom construktor
    public GroceryModel() {
    }

    public GroceryModel(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
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

    // To string
    @Override
    public String toString() {
        return "GroceryModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

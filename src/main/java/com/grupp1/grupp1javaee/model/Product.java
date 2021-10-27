package com.grupp1.grupp1javaee.model;

import javax.persistence.*;

@Entity
// skapar ett table i våran databas och lägger in de objekt som den här klassen skapar i det tablet
@Table(name = "product")
public class Product {

    @Id
    // autogenererar id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String name;
    private int price;
    private int amount;

    public Product() {
    }

    public Product(int id, String name, int price, int amount) {
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
        return "productModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}

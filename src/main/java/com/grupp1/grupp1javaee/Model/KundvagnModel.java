package com.grupp1.grupp1javaee.Model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "kundvagn")
public class KundvagnModel {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    // kan vara så att det behöver vara en "Integer" i stället
    private int kundvagn_id;
    private int user_id;
    private int Grocery_id;
    private int amount;
    private int price;

    private String grocery_name;
    private String user_name;




}

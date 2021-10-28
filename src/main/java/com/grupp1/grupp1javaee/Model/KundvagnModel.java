package com.grupp1.grupp1javaee.Model;

import com.grupp1.grupp1javaee.Service.KundvagnService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

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
    private int kundvagn_id;
    private String user_name;
    //private int user_id;
    //private int Grocery_id;
    private String grocery_name;
    private int price;
    private int amount;










}

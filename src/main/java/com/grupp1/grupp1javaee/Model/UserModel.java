package com.grupp1.grupp1javaee.Model;

import com.grupp1.grupp1javaee.Model.GroceryModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "user_list")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;

    @OneToMany(mappedBy = "owner")
    private List<GroceryModel> groceryList;




    private String userName;
    private String password;
    private String role;


    public UserModel() {
    }



}



package com.grupp1.grupp1javaee.Service;

import com.grupp1.grupp1javaee.Model.UserModel;
import com.grupp1.grupp1javaee.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;



    public List<UserModel> getUserS(){

        List<UserModel> userListS = userRepository.findAll();

        return userListS;

    }


    // hitta efter id
    public UserModel findUserByIdS(int id){

        return userRepository.findById(id).get();
    }


    public UserModel saveUserS(UserModel userModel){
        userRepository.save(userModel);

        return findUserByIdS(userModel.getUser_id());
    }


    public void deleteUserS(int id){
        userRepository.deleteById(id);
    }


    public UserModel updateUserS (UserModel userModel){
        userRepository.save(userModel);

        return userModel;
    }






    }






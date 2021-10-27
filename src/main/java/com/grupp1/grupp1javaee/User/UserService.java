package com.grupp1.grupp1javaee.User;

import com.grupp1.grupp1javaee.User.UserModel;
import com.grupp1.grupp1javaee.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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






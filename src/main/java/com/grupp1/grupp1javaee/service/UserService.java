package com.grupp1.grupp1javaee.service;

import com.grupp1.grupp1javaee.repository.UserRepository;
import com.grupp1.grupp1javaee.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository; //är det här vi implementerar vårt UserRepository

    public List<User> getUserS(){
        List<User> userListS = userRepository.findAll();
        return userListS;
    }

    // hitta efter id
    public User findUserByIdS(int id){
        return userRepository.findById(id).get();
    }

    public User saveUserS(User userModel){
        userRepository.save(userModel);
        return findUserByIdS(userModel.getId());
    }

    public void deleteUserS(int id){
        userRepository.deleteById(id);
    }

    public User updateUserS (User userModel){
        userRepository.save(userModel);
        return userModel;
    }




}

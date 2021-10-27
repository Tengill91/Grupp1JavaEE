package com.grupp1.grupp1javaee.controller;

import com.grupp1.grupp1javaee.model.User;
import com.grupp1.grupp1javaee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class UserController {


        // injektar in productService för den har dom färdiga metoderna i sig
        @Autowired
        UserService userService;

        // kanske ska döpa om productListHTML attributename till getAllproductsHTML

        @RequestMapping(path = "/users",method = RequestMethod.GET)
        private String getAllUsers(Model model) {
            List<User> userList = userService.getUserS();
            // Thymeleaf behöver ett namn för att länka in metoden till Html documentet
            model.addAttribute("userListHTML", userList);
            return "AllUsers";
        }


        @RequestMapping("/newUser")
        public String showNewUserPage(Model model) {
            // skapar ett nytt tomt objekt som kommer läggas in i UserService metoden för att sedan sparas
            User userModel = new User();
            //Viktigt productModel objektet blir en del utav editproductHtml namnet
            // (man använder alltså editproductHtml för att komma åt productModel objektets variabler)
            model.addAttribute("userModelHTML", userModel);
            // länkar till Addproduct.html
            return "AddUser";
        }

        // fråga kristoffer om @ModelAttribute
        @RequestMapping(path = "/saveUser", method = RequestMethod.POST)
        public String saveUser(@ModelAttribute("userModel") User userModel) {
            userService.saveUserS(userModel);
            return "redirect:/users";

        }

        @GetMapping("/editUser/{id}")
        private String editproduct(@PathVariable("id") int id, Model model) {
            User userModel = userService.findUserByIdS(id);
            model.addAttribute("editUserHtml", userModel);
            return "EditUser";

        }

        @RequestMapping(path = "/updateUser/{id}", method = RequestMethod.POST)
        private String updateUser(@PathVariable("id") int id, @ModelAttribute User userModel) {
            userModel.setId(id);
            userService.updateUserS(userModel);
            return "redirect:/users";
        }

        @GetMapping("/deleteUser/{id}")
        private String deleteUser(@PathVariable("id") int id) {
            userService.deleteUserS(id);
            return "redirect:/users";
        }



}
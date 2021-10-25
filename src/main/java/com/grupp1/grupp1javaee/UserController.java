package com.grupp1.grupp1javaee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class UserController {


        // injektar in GroceryService för den har dom färdiga metoderna i sig
        @Autowired
        UserService userService;

        // kanske ska döpa om groceryListHTML attributename till getAllGrocerysHTML

        @RequestMapping(path = "/users",method = RequestMethod.GET)
        private String getAllUsers(Model model) {
            List<UserModel> userList = userService.getUserS();
            // Thymeleaf behöver ett namn för att länka in metoden till Html documentet
            model.addAttribute("userListHTML", userList);
            return "AllUsers";
        }


        @RequestMapping("/newUser")
        public String showNewUserPage(Model model) {
            // skapar ett nytt tomt objekt som kommer läggas in i UserService metoden för att sedan sparas
            UserModel userModel = new UserModel();
            //Viktigt groceryModel objektet blir en del utav editGroceryHtml namnet
            // (man använder alltså editGroceryHtml för att komma åt groceryModel objektets variabler)
            model.addAttribute("userModelHTML", userModel);
            // länkar till AddGrocery.html
            return "AddUser";
        }

        // fråga kristoffer om @ModelAttribute
        @RequestMapping(path = "/saveUser", method = RequestMethod.POST)
        public String saveUser(@ModelAttribute("userModel") UserModel userModel) {
            userService.saveUserS(userModel);
            return "redirect:/users";

        }

        @GetMapping("/editUser/{id}")
        private String editGrocery(@PathVariable("id") int id, Model model) {
            UserModel userModel = userService.findUserByIdS(id);
            model.addAttribute("editUserHtml", userModel);
            return "EditUser";

        }

        @RequestMapping(path = "/updateUser/{id}", method = RequestMethod.POST)
        private String updateUser(@PathVariable("id") int id, @ModelAttribute UserModel userModel) {
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
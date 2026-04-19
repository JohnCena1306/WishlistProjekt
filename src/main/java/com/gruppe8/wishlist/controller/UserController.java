package com.gruppe8.wishlist.controller;

import com.gruppe8.wishlist.model.User;
import com.gruppe8.wishlist.service.UserService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

   @GetMapping ("/login")
    public String login(User user){
       return "login";
   }

    @GetMapping ("/register")
    public String register(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping ("/register")
    public String saveUser(@ModelAttribute User user){

        userService.addUser(user);

        return "redirect:/login";
    }


}

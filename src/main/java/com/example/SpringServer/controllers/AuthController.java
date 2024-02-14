package com.example.SpringServer.controllers;

import com.example.SpringServer.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    @GetMapping("/auth")
    public String getAuthPage(Model model){
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("head", "Авторизация");
        return "auth";
    }

    @PostMapping("/auth")
    public String authentification(Model model, @ModelAttribute User user){
        System.out.println(user.getLogin() + " " + user.getPassword());
        return "home";
    }
}

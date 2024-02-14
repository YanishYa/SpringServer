package com.example.SpringServer.restControllers;

import com.example.SpringServer.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class RegistrationController {

    @GetMapping("/")
    public String reg(Model model){
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("head", "Регистрация");
        return "registration";
    }

    @PostMapping("/")
    public String register(Model model, @ModelAttribute User user){
        System.out.println(user.getLogin() + " " + user.getPassword());

        return "auth";
    }
}

package com.example.SpringServer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {
    @GetMapping("/blog")
    public String blogMain(Model model)
    {
        model.addAttribute("about", "/about?title=Zdarova eta grechka dlya vas");
        model.addAttribute("head", "Блог");
        return "blog-main";
    }
}

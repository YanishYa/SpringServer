package com.example.SpringServer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/about")
public class AboutController {

    @GetMapping()
    public String about(@RequestParam(value = "title") String title, Model model)
    {
        model.addAttribute("head", "О нас");
        model.addAttribute("about", "/about?title=О нас");
        model.addAttribute("blog", "/blog");
        if (title == null)
            title = "no title";
        model.addAttribute("title", title);
        return "about";
    }
}

package com.example.SpringServer.controllers;

import com.example.SpringServer.entity.PlaceRepository;
import com.example.SpringServer.entity.User;
import com.example.SpringServer.templateData.ParcePlaceAdder;
import com.example.SpringServer.templateData.ParseAdapter;
import com.example.SpringServer.entity.Place;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class MainController {

    @GetMapping("/main")
    public String home(Model model) {
        model.addAttribute("head", "Главная страница");
        model.addAttribute("title", "Главная страница");
        model.addAttribute("about", "/about?title=Privet ");
        model.addAttribute("blog", "/blog");
        try {
            List<Place> places = ParseAdapter.getList();
            model.addAttribute("places", places);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return "home";
    }
    @GetMapping("/mainLog")
    public String hello(Model model){
        model.addAttribute("head", "Главная страница");
        model.addAttribute("title", "Привет");
        model.addAttribute("about", "/about?title=Privet ");
        model.addAttribute("blog", "/blog");
        try {
            List<Place> places = ParseAdapter.getList();
            model.addAttribute("places", places);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return "home";
    }

    @GetMapping("/refreshPlaces")
    public String refreshPlaces(Model model){
        ParcePlaceAdder.AddPlaces();
        return "redirect:/main";
    }

}

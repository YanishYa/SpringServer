package com.example.SpringServer.templateData;

import java.util.LinkedList;
import java.util.List;

import com.example.SpringServer.entity.Place;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ParseAdapter {
    public static List<Place> getList(){
        TripadvisorParce tripadvisorParce = new TripadvisorParce();
        List<Place> places = tripadvisorParce.getParse();
        KudaGoParse kudaGoParse = new KudaGoParse();
        for (Place item : kudaGoParse.getParse()){
            places.add(item);
        }
        return places;
    }
}

package com.example.SpringServer.templateData;

import com.example.SpringServer.entity.Place;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.LinkedList;
import java.util.List;

public class TripadvisorParce extends ParcerAbstractTemplate {
    public List<Place> getParse(){
        url = "https://www.tripadvisor.ru/Attractions-g1439536-Activities-Khimki_Moscow_Oblast_Central_Russia.html";
        docSelect = "section.jemSU";
        elemSelect = "div.XfVdV.o.AIbhI";
        List<Place> places = new LinkedList<>();
        try {
            Document doc = Jsoup.connect(url).userAgent("Mozilla").get();
            Elements listElements = doc.select(docSelect);
            for (Element item : listElements.select(elemSelect)){
                places.add(new Place(item.text()));
            }
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return places;
    }
}

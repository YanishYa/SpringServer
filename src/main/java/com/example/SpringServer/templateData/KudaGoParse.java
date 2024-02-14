package com.example.SpringServer.templateData;

import com.example.SpringServer.entity.Place;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.LinkedList;
import java.util.List;

public class KudaGoParse extends ParcerAbstractTemplate{
    public List<Place> getParse(){
        url = "https://kudago.com/msk/list/kuda-shodit-v-himkah/";
        docSelect = "div.post-list-item-description";
        elemSelect = "h4.post-list-item-title";
        List<Place> places = new LinkedList<>();
        try {
            Document doc = Jsoup.connect(url).get();
            Elements listElements = doc.select(docSelect);
            for(Element item : listElements.select(elemSelect)){
                places.add(new Place(item.text()));
            }
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return places;
    }
}

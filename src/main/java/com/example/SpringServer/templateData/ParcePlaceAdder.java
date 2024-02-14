package com.example.SpringServer.templateData;

import com.example.SpringServer.entity.Place;
import com.example.SpringServer.entity.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ParcePlaceAdder {
    @Autowired
    static PlaceRepository placeRepository;
    public static void AddPlaces(){
        TripadvisorParce tripadvisorParce = new TripadvisorParce();
        List<Place> places = tripadvisorParce.getParse();
        KudaGoParse kudaGoParse = new KudaGoParse();
        List<Place> pl = kudaGoParse.getParse();

        for (Place item : pl){
            boolean finded = false;
            for (Place place : placeRepository.findAll()) {
                if (place.getName() == item.getName()){
                    finded = true;
                    break;
                }
            }
            if (!finded){
                placeRepository.save(item);
            }
        }
    }
}

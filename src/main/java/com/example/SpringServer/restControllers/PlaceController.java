package com.example.SpringServer.restControllers;


import com.example.SpringServer.ResourceNotFoundException;
import com.example.SpringServer.entity.Place;
import com.example.SpringServer.entity.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/place")
public class PlaceController {
    @Autowired
    private PlaceRepository placeRepository;
    @GetMapping("/allPlaces")
    public List<Place> getAllPlaces(){
        return (List<Place>) placeRepository.findAll();
    }
    @PostMapping("/createPlace")
    public Place createPlace(@ModelAttribute Place place) {
        Place nPlace = placeRepository.save(place);
        return nPlace;
    }
    @GetMapping("/getPlace")
    public ResponseEntity<Place> getPlace(@ModelAttribute Place place) {
        Iterable<Place> places = placeRepository.findAll();
        for (Place p : places){
            if (p.getName().equals(place.getName())){
                System.out.println(p.getName());
                return ResponseEntity.ok(place);
            }
        }
        return (ResponseEntity<Place>) ResponseEntity.notFound();
    }
}

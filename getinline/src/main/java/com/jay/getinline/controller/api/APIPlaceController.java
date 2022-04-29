package com.jay.getinline.controller.api;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/admin")
@RestController
public class APIPlaceController {

    @GetMapping("/places")
    public String adminPlaces() {
        return "";
    }

    @GetMapping("/places/{placeIdd}")
    public String getPlaces(@PathVariable String placeId) {
        return "";
    }

    @PutMapping("/")
    public String postPlaces(@PathVariable String place_id){
        return "";
    }
}

package com.jay.getinline.controller.api;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/places")
@RestController
public class APIPlaceController {

    @GetMapping("/")
    public String placelist() {
        return "";
    }

    @GetMapping("/{place_id}")
    public String getPlaces(@PathVariable String place_id) {
        return "";
    }

    @PutMapping("/")
    public String postPlaces(@PathVariable String place_id){
        return "";
    }
}

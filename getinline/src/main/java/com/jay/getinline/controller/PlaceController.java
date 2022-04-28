package com.jay.getinline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/places")
@Controller
public class PlaceController {

    @GetMapping("/")
    public String getPlaces() {
        return "";
    }

    @GetMapping("/{place-id}")
    public String getPlaces(@PathVariable String placeId) {
        return "";
    }
}

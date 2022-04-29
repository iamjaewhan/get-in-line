package com.jay.getinline.controller;

import com.jay.getinline.constant.PlaceType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;


@RequestMapping("/admin")
@Controller
public class AdminController {

    @GetMapping("/places")
    public ModelAndView adminPlaces(
            PlaceType placeType,
            String placeName,
            String address
            ) {
        Map<String, Object> map = new HashMap<>();
        map.put("placeType", placeName);
        map.put("placeName", placeName);
        map.put("address", address);
        return new ModelAndView("admin/places", map);
    }

    @GetMapping("/{place-id}")
    public String getOnePlace(@PathVariable String placeId) {
        return "";
    }

    @GetMapping("/events")
    public String eventList () {
        return "";
    }

    @GetMapping("/events/{eventId}")
    public String getEvent(@PathVariable String eventId) {
        return "";
    }
}

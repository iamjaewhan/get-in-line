package com.jay.getinline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin")
@Controller
public class AdminController {

    @GetMapping("/places")
    public String getPlaces() {
        return "";
    }

    @GetMapping("/{place-id}")
    public String getOnePlace(@PathVariable String placeId) {
        return "";
    }

    @GetMapping("/events")
    public String eventList () {
        return "";
    }

    @GetMapping("/events/{event-id}")
    public String getEvent(@PathVariable String eventId) {
        return "";
    }
}

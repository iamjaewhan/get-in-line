package com.jay.getinline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
@Controller
public class EventController {

    @GetMapping("/events")
    public String events() {
        return "event/index";
    }

    @GetMapping("/events/{eventId}")
    public String eventDetail(@PathVariable Integer eventId) {
        return "event/detail";
    }

}
package com.jay.getinline.controller.api;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class APIEventController {

    @GetMapping("/evnets")
    public List<String> getEvents() {

        return List.of("event1", "event2");
    }

    @GetMapping("/{event-id}")
    public String getEventById(@PathVariable String eventId) {
        return "";
    }

    @PostMapping("/")
    public String postEvent(@PathVariable String eventId) {
        return "";
    }

    @PutMapping("/{event-id}")
    public String updateEvent(@PathVariable String eventId){
        return "";
    }

    @DeleteMapping("/{event-id}")
    public String deleteEvent(@PathVariable String eventId){
        return "";
    }
}

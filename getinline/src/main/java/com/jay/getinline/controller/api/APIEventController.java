package com.jay.getinline.controller.api;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/events")
@RestController
public class APIEventController {

    @GetMapping("/")
    public String getEventList() {
        return "";
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

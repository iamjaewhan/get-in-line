package com.jay.getinline.controller.api;

import com.jay.getinline.constant.ErrorCode;
import com.jay.getinline.dto.APIErrorResponse;
import com.jay.getinline.exception.GeneralException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class APIEventController {

    @GetMapping("/events")
    public List<String> getEvents() throws HttpRequestMethodNotSupportedException {
        throw new HttpRequestMethodNotSupportedException("response entity exception handler 테스트");
        //return List.of("event1", "event2");
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

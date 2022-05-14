package com.jay.getinline.controller.api;

import com.jay.getinline.constant.ErrorCode;
import com.jay.getinline.constant.EventStatus;
import com.jay.getinline.dto.APIDataResponse;
import com.jay.getinline.dto.APIErrorResponse;
import com.jay.getinline.dto.EventDTO;
import com.jay.getinline.dto.EventResponse;
import com.jay.getinline.exception.GeneralException;
import com.jay.getinline.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class APIEventController {

    private final EventService eventService;

    @GetMapping("/events")
    public APIDataResponse<List<EventResponse>> getEvents(
            Long placeId,
            String eventName,
            EventStatus eventStatus,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime eventStartDatetime,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime eventEndDatetime
    ){
        List<EventResponse> response = eventService
                .getEvents(placeId, eventName, eventStatus,  eventStartDatetime, eventEndDatetime)
                .stream().map(EventResponse::from).toList();

        return APIDataResponse.of(response);
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

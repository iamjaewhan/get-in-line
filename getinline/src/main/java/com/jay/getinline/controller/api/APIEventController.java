package com.jay.getinline.controller.api;

import com.jay.getinline.DTO.APIDataResponse;
import com.jay.getinline.DTO.EventRequest;
import com.jay.getinline.DTO.EventResponse;
import com.jay.getinline.constant.EventStatus;
import com.jay.getinline.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Validated
@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class APIEventController {

    private final EventService eventService;

    @GetMapping("/events")
    public APIDataResponse<List<EventResponse>> getEvents(
            @Positive Long placeId,
            @Size(min = 2) String eventName,
            EventStatus eventStatus,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime eventStartDatetime,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime eventEndDatetime
    )
    {
        List<EventResponse> response = eventService
                .getEvents(placeId, eventName, eventStatus, eventStartDatetime, eventEndDatetime)
                .stream().map(EventResponse::from).toList();
        return APIDataResponse.of(response);
    }

    @ResponseStatus(HttpStatus.CREATED) //반환 status를 201로 반환
    @PostMapping("/events")
    public APIDataResponse<Void> createEvent(@Valid @RequestBody EventRequest request) {
        return APIDataResponse.empty();
    }

    @GetMapping("/events/{eventId}")
    public APIDataResponse<EventResponse> getEvent(@PathVariable Integer eventId) {
        return APIDataResponse.of(EventResponse.of(
                1L,
                "오후 운동",
                EventStatus.OPENED,
                LocalDateTime.of(2021, 1, 1, 13, 0, 0),
                LocalDateTime.of(2021, 1, 1, 16, 0, 0),
                0,
                24,
                "마스크 꼭 착용하세요"
        ));
    }

    @PutMapping("/events/{eventId}")
    public APIDataResponse modifyEvent(@PathVariable Long eventId, @RequestBody EventRequest request){
        //TODO 이벤트 수정 구현
        return APIDataResponse.empty();
    }


    @DeleteMapping("/events/{eventId}")
    public APIDataResponse<Void> removeEvent(@PathVariable Long eventId) {
        //TODO 이벤트 삭제 구현
        return APIDataResponse.empty();
    }
}

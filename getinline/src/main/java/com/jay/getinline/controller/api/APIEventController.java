package com.jay.getinline.controller.api;

import com.jay.getinline.DTO.APIDataResponse;
import com.jay.getinline.DTO.EventRequest;
import com.jay.getinline.DTO.EventResponse;
import com.jay.getinline.constant.EventStatus;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/api")
@RestController
public class APIEventController {

    @GetMapping("/events")
    public APIDataResponse<List<EventResponse>> getEvents() {
        return APIDataResponse.of(List.of(EventResponse.of(
                1L,
                "오후 운동",
                EventStatus.OPENED,
                LocalDateTime.of(2021, 1, 1, 13, 0, 0),
                LocalDateTime.of(2021, 1, 1, 16, 0, 0),
                0,
                24,
                "마스크 꼭 착용하세요"
        )));
    }

    @ResponseStatus(HttpStatus.CREATED) //반환 status를 201로 반환
    @PostMapping("/events")
    public APIDataResponse<Void> createEvent(@RequestBody EventRequest request) {
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

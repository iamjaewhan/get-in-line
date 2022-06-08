package com.jay.getinline.service;

import com.jay.getinline.DTO.EventDTO;
import com.jay.getinline.constant.ErrorCode;
import com.jay.getinline.constant.EventStatus;
import com.jay.getinline.exception.GeneralException;
import com.jay.getinline.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EventService{

    private final EventRepository eventRepository;


    public List<EventDTO> getEvents(
            Long placeId,
            String eventName,
            EventStatus eventStatus,
            LocalDateTime eventStartDatetime,
            LocalDateTime eventEndDatetime
    ) {
        try {
            return eventRepository.findEvents(
                    placeId,
                    eventName,
                    eventStatus,
                    eventStartDatetime,
                    eventEndDatetime
            );
        }
        catch (Exception e) {
            throw new GeneralException(ErrorCode.DATA_ACCESS_ERROR, e);
        }
    }


    public Optional<EventDTO> getEvent(Long eventId){
        return eventRepository.findEvent(eventId);
    }

    public boolean createEvent(EventDTO eventDTO){
        return eventRepository.insertEvent(eventDTO);
    }

    public boolean modifyEvent(Long eventId, EventDTO eventDTO){
        return eventRepository.updateEvent(eventId, eventDTO);
    }

    public boolean removeEvent(Long eventId){
        return eventRepository.deleteEvent(eventId);
    }
}

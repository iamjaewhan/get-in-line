package com.jay.getinline.repository;


import com.jay.getinline.constant.EventStatus;
import com.jay.getinline.dto.EventDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface EventRepository {

    default List<EventDTO> findEvents(
            Long placeId,
            String eventName,
            EventStatus eventStatus,
            LocalDateTime eventStartDatetime,
            LocalDateTime eventEndDatetime
    ) { return List.of(); }

    default Optional<EventDTO> findEvents(Long eventId) { return Optional.empty(); }
    default boolean insertEvent(EventDTO eventDTO) { return false; }
    default boolean updateEvent(Long eventId, EventDTO eventDTO) { return false; }
    default boolean deleteEvent(Long eventId) { return false; }
}

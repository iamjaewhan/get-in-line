package com.jay.getinline.service;

import com.jay.getinline.constant.EventStatus;
import com.jay.getinline.domain.Event;
import com.jay.getinline.dto.EventDTO;
import com.jay.getinline.repository.EventRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class EventServiceTest {

    @InjectMocks private EventService sut;
    @Mock private EventRepository eventRepository;


    @DisplayName("Display entire result, given nothing")
    @Test
    void givenNothing_whenSearchingEvents_thenReturnsEntireEventList(){
        //given
        given(eventRepository.findEvents(null,null,null,null,null))
                .willReturn(List.of(
                        createEventDTO(1L, "오전 운동", true),
                        createEventDTO(1L, "오후 운동", false)
                ));
        //when
        List<EventDTO> list = sut.getEvents(null,null,null,null,null);

        //then
        assertThat(list).isNotNull();
        verify(eventRepository).findEvents(null, null,null,null,null);
    }

    @DisplayName("Display search result, given search parameters")
    @Test
    void givenSearchParams_whenSearchingEvents_thenReturnsEventList(){
        //given
        Long placeId = 1L;
        String eventName = "오전 운동";
        EventStatus eventStatus = EventStatus.OPENED;
        LocalDateTime eventStartDatetime = LocalDateTime.of(2021,1,1,0,0);
        LocalDateTime eventEndDatetime = LocalDateTime.of(2021,1,1,2,0);

        given(eventRepository.findEvents(placeId, eventName, eventStatus, eventStartDatetime, eventEndDatetime))
                .willReturn(List.of(
                        createEventDTO(1L, "오전운동", eventStatus, eventStartDatetime, eventEndDatetime)
                ));

        //when
        List<EventDTO> list = sut.getEvents(placeId, eventName, eventStatus, eventStartDatetime, eventEndDatetime);

        //then
        assertThat(list)
                .hasSize(1)
                .allSatisfy(event -> {
                    assertThat(event)
                            .hasFieldOrPropertyWithValue("placeId", placeId)
                            .hasFieldOrPropertyWithValue("eventName", eventName )
                            .hasFieldOrPropertyWithValue("eventStatis", eventStatus);
                    assertThat(event.eventStartDatetime()).isAfterOrEqualTo(eventStartDatetime);
                    assertThat(event.eventStartDatetime()).isBeforeOrEqualTo(eventStartDatetime);
                });
        then(eventRepository).should().findEvents(placeId, eventName, eventStatus, eventStartDatetime, eventEndDatetime);
    }

    @DisplayName("search by event id exists, returns specific event info")
    @Test
    void givenEventId_whenSearchingExistingEvent_thenReturnsEvent() {
        //given
        long eventId = 1L;
        EventDTO eventDTO = createEventDTO(1L, "오전 운동", true);
        given(eventRepository.findEvents(eventId)).willReturn(Optional.of(eventDTO));

        //when
        Optional<EventDTO> result = sut.getEvent(eventId);

        //then
        assertThat(result).hasValue(eventDTO);
        then(eventRepository).should().findEvents(eventId);
    }

    @DisplayName("search by event id, returns empty info")
    @Test
    void givenEventId_whenSearchingNonExistingEvent_thenReturnsEmptyOptional() {
        //given
        long eventId = 2L;
        EventDTO eventDTO = createEventDTO(1L, "오전 운동", true);
        given(eventRepository.findEvents(eventId)).willReturn(Optional.empty());

        //when
        Optional<EventDTO> result = sut.getEvent(eventId);

        //then
        assertThat(result).isEmpty();
        then(eventRepository).should().findEvents(eventId);
    }

    @DisplayName("given event info, create event then returns true")
    @Test
    void givenEvent_whenCreating_thenCreatesEventAndReturnsTrue() {
        //given
        EventDTO dto = createEventDTO(1L, "오후 운동", false);
        given(eventRepository.insertEvent(dto)).willReturn(true);

        //when
        boolean result =sut.createEvent(dto);

        //then
        assertThat(result).isTrue();
        then(eventRepository).should().insertEvent(dto);
    }

    @DisplayName("Not given event info, stop creating then returns false")
    @Test
    void givenNothing_whenCreating_thenAbortCreatingAndReturnsFalse() {
        //given
        given(eventRepository.insertEvent(null)).willReturn(false);

        //when
        boolean result =sut.createEvent(null);

        //then
        assertThat(result).isFalse();
        then(eventRepository).should().insertEvent(null);
    }

    @DisplayName("given eventid and info, modify event info and returns true")
    @Test
    void givenEventId_whenModifying_thenModifiesEventAndReturnsTrue() {
        //given
        long eventId = 1L;
        EventDTO dto = createEventDTO(1L, "오후 운동", false);
        given(eventRepository.updateEvent(eventId, dto)).willReturn(true);

        //when
        boolean result =sut.modifyEvent(eventId, dto);

        //then
        assertThat(result).isTrue();
        then(eventRepository).should().updateEvent(eventId, dto);
    }

    @DisplayName("not given eventid , abort modifying event info and returns false")
    @Test
    void givenNothing_whenModifying_thenAbortModifyingEventAndReturnsFalse() {
        //given
        EventDTO dto = createEventDTO(1L, "오후 운동", false);
        given(eventRepository.updateEvent(null,dto)).willReturn(false);

        //when
        boolean result =sut.modifyEvent(null, dto);

        //then
        assertThat(result).isFalse();
        then(eventRepository).should().updateEvent(null,dto);
    }

    @DisplayName("given event id, delete event then returns true")
    @Test
    void givenEventId_whenDeleting_thenDeletesEventAndReturnsTrue(){
        //given
        long eventId = 1L;
        given(eventRepository.deleteEvent(eventId)).willReturn(true);

        //when
        boolean result = eventRepository.deleteEvent(eventId);

        //then
        assertThat(result).isTrue();
        then(eventRepository).should().deleteEvent(eventId);
    }

    @DisplayName("given nothing, abort delete event then returns false")
    @Test
    void givenNothing_whenDeleting_thenAbortsDeletesEventAndReturnsFalse(){
        //given
        given(eventRepository.deleteEvent(null)).willReturn(false);

        //when
        boolean result = eventRepository.deleteEvent(null);

        //then
        assertThat(result).isFalse();
        then(eventRepository).should().deleteEvent(null);
    }

    private EventDTO createEventDTO(long placeId, String eventName, boolean isMorning) {
        String hourStart = isMorning ? "09" : "13";
        String hourEnd = isMorning ? "12" : "16";

        return createEventDTO(
                placeId,
                eventName,
                EventStatus.OPENED,
                LocalDateTime.parse("2021-01-01T%s:00:00".formatted(hourStart)),
                LocalDateTime.parse("2021-01-01T%s:00:00".formatted(hourEnd))
        );
    }

    private EventDTO createEventDTO(
            long placeId,
            String eventName,
            EventStatus eventStatus,
            LocalDateTime eventStartDateTime,
            LocalDateTime eventEndDateTime
    ) {
        return EventDTO.of(
                placeId,
                eventName,
                eventStatus,
                eventStartDateTime,
                eventEndDateTime,
                0,
                24,
                "마스크 꼭 착용하세요",
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }
}
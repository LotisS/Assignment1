package com.lotissacayan.eventservice.service;

import com.lotissacayan.eventservice.model.Event;
import com.lotissacayan.eventservice.repository.EventRepository;
import com.lotissacayan.eventservice.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;

public class EventService {


    private final EventRepository eventRepository;
    private final RestTemplate restTemplate;

    private String userServiceUrl;

    @Autowired
    public EventService(EventRepository eventRepository, RestTemplate restTemplate) {
        this.eventRepository = eventRepository;
        this.restTemplate = restTemplate;
    }


    public Event createEvent( String userId, Event event){
        String url = userServiceUrl + "/api/users/" + userId = "/role";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        String role = response.getBody();

        if ("faculty".equals(role)) {
            return eventRepository.save(event);
        }  else if ("student".equals(role)){
            if(event.getExpectedAttendees() > 50){
                throw new RuntimeException(" Students cannot organize events with  les than 50 attendees:");
            }
            return eventRepository.save(event);
        }else{
            throw new RuntimeException("User role not authorized to create events:");
        }





        return eventRepository.save(event);
    }

    public List<Event> getAllEvents(){
        return eventRepository.findAll();
    }

    public Event getEventById( String id){
        return eventRepository.findById(id).orElseThrow(() -> new RuntimeException("Event not Found!"));
    }

    public List<Event> getEventsByOrganizer(String organizerId) {
        return eventRepository.findByOrganizerId(organizerId);
    }

    public List<Event> getEventByRoom(String roomId){
        return eventRepository.findByRoomId(roomId);
    }



    public Event updateEvent(String id, Event updatedEvent){
        Event event = getEventById(id);
        event.setEventName(updatedEvent.getEventName());
        event.setEventType(updatedEvent.getEventType());
        event.setExpectedAttendees(updatedEvent.getExpectedAttendees());
        event.setRoomId(updatedEvent.getRoomId());
        return eventRepository.save(event);
    }

    public void deleteEvent(String id){
        eventRepository.deleteById(id);
    }
    public boolean roomAvailable(String roomId, LocalDateTime startTime, LocalDateTime endTime){

        List<Event> conflictEvents = eventRepository.findEventByRoomIdAndTimeRange(roomId, startTime, endTime);
        return conflictEvents.isEmpty();
    }
}





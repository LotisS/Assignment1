package com.lotissacayan.eventservice.controller;


import com.lotissacayan.eventservice.model.Event;
import com.lotissacayan.eventservice.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {


    private final EventService eventService;

    public EventController(EventService eventService){
        this.eventService = eventService;
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<Event> getEventDetails(@PathVariable String eventId){
        Event event = eventService.getEventById(eventId);
    }


    @PostMapping
    public Event createEvent(@RequestBody Event event){

        return eventService.createEvent(event);
    }

    @GetMapping("/organizer/{organizerId}")
    public List<Event> getEventsByRoom(@PathVariable String roomId) {

        return eventService.getEventByRoom(roomId);
    }

    @PutMapping("/id")
    public Event updateEvent(@PathVariable String id, @RequestBody Event updateEvent){
        return eventService.updateEvent(id, updateEvent);
    }


    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable String id) {
        eventService.deleteEvent(id);
    }
}

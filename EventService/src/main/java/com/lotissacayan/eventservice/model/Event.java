package com.lotissacayan.eventservice.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Document(collection = "events")
@Data
public class Event {

    @Id
    private String id = UUID.randomUUID().toString();

    private String eventName;
    private String organizerId;
    private String eventType;
    private int attendees;
    private String roomId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Event(){}


    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }
    public String getEventName(){
        return eventName;
    }

    public void setEventName( String eventName){
        this.eventName = eventName;
    }
    public String getOrganizerId(){
        return organizerId;
    }
    public void setOrganizerId(String organizerId){
        this.organizerId = organizerId;
    }

    public String getEventType(){
        return eventType;
    }

    public void setEventType(String eventType){
        this.eventType = eventType;
    }

    public int getAttendees(){
        return attendees;
    }

    public void setExpectedAttendees( int  expectedAttendees){
        this.attendees = expectedAttendees;
    }

    public String getRoomId(){
        return roomId;
    }

    public void setRoomId(String roomId){
        this.roomId = roomId;
    }

    public LocalDateTime getStartTime(){
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime){
        this.startTime = startTime;
    }
    public LocalDateTime getEndTime(){
        return endTime;
    }
    public void setEndTime(LocalDateTime endTime){
        this.endTime = endTime;
    }

    public Event(String eventName, String organizerId, String eventType, int attendees, String roomId){
        this.eventName = eventName;
        this.organizerId = organizerId;
        this.eventType = eventType;
        this.attendees = attendees;
        this.roomId = roomId;


    }

}

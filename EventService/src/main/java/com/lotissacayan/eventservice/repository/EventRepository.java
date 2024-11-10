package com.lotissacayan.eventservice.repository;

import com.lotissacayan.eventservice.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface EventRepository  extends MongoRepository<Event, String > {

    List<Event> findByOrganizerId(String organizerId);
    List<Event> findByRoomIdAndTimeRange(String roomId, LocalDateTime startTime, LocalDateTime endtime);

}

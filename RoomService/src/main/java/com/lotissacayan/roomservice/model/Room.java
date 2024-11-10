package com.lotissacayan.roomservice.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@NoArgsConstructor
@Builder
@Data
@Document(collection = "rooms")

public class Room {


    @Id
    private Long id;
    private String roomName;
    private int capacity;
    private boolean availability;

    private List<String> features;


    public Room(String roomName, int capacity, boolean availability, List<String> features) {
        this.roomName = roomName;
        this.capacity = capacity;
        this.availability = availability;
        this.features = features;

    }


}


package com.lotissacayan.roomservice.controller;


import com.lotissacayan.roomservice.dto.RoomRequest;
import com.lotissacayan.roomservice.dto.RoomRespond;
import com.lotissacayan.roomservice.model.Room;
import com.lotissacayan.roomservice.service.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/api/rooms")
public class RoomController {


    private final RoomService roomService;

    public RoomController(RoomService roomService){

        this.roomService = roomService;

    }

    @GetMapping("/availability")
    public ResponseEntity<RoomRespond> createRoom(@RequestBody RoomRequest roomRequest){
        Room room = new Room(
                roomRequest.name(),
                roomRequest.capacity(),
                roomRequest.availability(),
                roomRequest.features()
        );


        Room createdRoom = roomService.createRoom(room);


        RoomRespond roomRespond = new RoomRespond(

                createdRoom.getId(),
                createdRoom.getRoomName(),
                createdRoom.getCapacity(),
                createdRoom.isAvailability()

        );
        return  ResponseEntity.ok(roomRespond);

    }
    @GetMapping("/availability")
    public ResponseEntity<Boolean> checkAvailability(
            @RequestParam String roomId,
            @RequestParam LocalDateTime startTime,
            @RequestParam LocalDateTime endTime
    ){
        boolean isAvailable = roomService.isRoomAvailable(roomId, startTime, endTime);
        return ResponseEntity.ok(isAvailable);
    }



    @GetMapping
    public ResponseEntity<List<Room>> getAllRooms(){
        List<Room> room = roomService.getAllRooms();
        return ResponseEntity.ok(room);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable Long id){
        Room room = roomService.getRoomById(id);
        return ResponseEntity.ok(room);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable Long id, @RequestBody Room roomDetails){
        Room updatedRoom = roomService.updateRoom(id, roomDetails);
        return ResponseEntity.ok(updatedRoom);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Room> deleteRoom(@PathVariable Long id){
        roomService.deleteRoom(id);
        return ResponseEntity.noContent().build();
    }

}

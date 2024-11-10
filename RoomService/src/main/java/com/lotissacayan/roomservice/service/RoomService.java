package com.lotissacayan.roomservice.service;
import com.lotissacayan.bookingservice.model.Booking;
import com.lotissacayan.bookingservice.service.BookingService;
import com.lotissacayan.roomservice.model.Room;
import com.lotissacayan.roomservice.repository.RoomRepository;
import com.lotissacayan.bookingservice.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    private final RoomRepository roomRepository;
    private RestTemplate restTemplate = null;

    @Value(("${bookingservice.url=http://localhost:8081}"))
    private String bookingServiceUrl;

    public RoomService(RoomRepository roomRepository, BookingRepository bookingRepository, BookingService bookingService, BookingRepository bookingRepository1){

        this.roomRepository = roomRepository;
        this.restTemplate = restTemplate;
    }

    public Room createRoom(Room room){

        return roomRepository.save(room);
    }

    public List<Room> getAllRooms(){

        return roomRepository.findAll();
    }

    public Room getRoomById(Long id){
        return roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not Found" + id));


    }


    public Room updateRoom(Long id, Room roomDetails){
        return roomRepository.findById(id)
                .map(room -> {
                    room.setRoomName(roomDetails.getRoomName());
                    room.setCapacity(roomDetails.getCapacity());
                    room.setAvailability(roomDetails.isAvailability());
                    room.setFeatures(roomDetails.getFeatures());
                    return roomRepository.save(room);
                })
                .orElseThrow(() -> new RuntimeException("Room not found " + id));
    }

    public void deleteRoom(Long id){

        roomRepository.deleteById(id);
    }

    public boolean isRoomAvailable(String roomId, LocalDateTime startDate, LocalDateTime endDate) {
        String bookingServiceUrl = "";
        String url = bookingServiceUrl + "/api/bookings/check-availability?roomId=" + roomId +
                "&startDate=" + startDate + "&endDate=" + endDate;


        ResponseEntity<Boolean> response = restTemplate.getForEntity(url, Boolean.class);
        return Boolean.TRUE.equals(response.getBody());



    }



}

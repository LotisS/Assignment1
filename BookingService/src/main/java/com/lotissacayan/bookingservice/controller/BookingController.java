package com.lotissacayan.bookingservice.controller;

import com.lotissacayan.bookingservice.model.Booking;
import com.lotissacayan.bookingservice.service.BookingService;
import com.lotissacayan.bookingservice.service.RoomNotAvailableException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")

public class BookingController {

    private final BookingService bookingService;


    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking){
        return new ResponseEntity<>(bookingService.createBooking(booking), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Booking> getAllBookings(){
        return bookingService.getAllBookings();
    }


    @GetMapping("/check-availability")
    public ResponseEntity<Boolean> checkAvailability(
            @RequestParam String roomId,
            @RequestParam LocalDateTime startDate,
            @RequestParam LocalDateTime endDate){
        boolean isAvailable = bookingService.isRoomAvailable(roomId, startDate, endDate);
        return ResponseEntity.ok(isAvailable);
    }

    @ControllerAdvice
    public  static class GlobalExceptionHandler {
        
        @ExceptionHandler(RoomNotAvailableException.class)
        public ResponseEntity<String> handleRoomNotAvailableException(RoomNotAvailableException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
        }
    }

}

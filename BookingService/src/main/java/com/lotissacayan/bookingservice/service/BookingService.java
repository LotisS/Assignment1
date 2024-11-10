package com.lotissacayan.bookingservice.service;

import com.lotissacayan.bookingservice.model.Booking;
import com.lotissacayan.bookingservice.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class BookingService {

     private final BookingRepository bookingRepository;

     public BookingService(BookingRepository bookingRepository){
         this.bookingRepository = bookingRepository;
     }


     public Booking createBooking(Booking booking){
         return bookingRepository.save(booking);

     }

     private void validateBooking(String roomId, LocalDateTime startTime, LocalDateTime endTime){
         List<Booking> doubleBookings = bookingRepository
                 .findByRoomIdAndStartTimeLessThanEqualAndEndTimeGreaterThanEqual(roomId, endTime, startTime);
         if(!doubleBookings.isEmpty()){
             throw new RoomNotAvailableException(" Room is not available at the specific time.");
         }
     }
     public List<Booking> getAllBookings(){
         return bookingRepository.findAll();
     }
}

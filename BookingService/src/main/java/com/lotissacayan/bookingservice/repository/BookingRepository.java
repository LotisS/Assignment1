package com.lotissacayan.bookingservice.repository;

import com.lotissacayan.bookingservice.model.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Repository
public interface BookingRepository extends MongoRepository<Booking, String>{

    List<Booking> findByRoomId(String roomId);

    List<Booking> findByBookingId(String bookingId);


    List<Booking> findByStartDate(LocalDate startDate);

    List<Booking> findByEndDate(LocalDate endDate);


    List<Booking> findByRoomIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(String roomId, LocalDateTime endTime, LocalDateTime startTime);

    List<Booking> findByRoomIdAndStartTimeLessThanEqualAndEndGreaterThanEqual(String roomId, LocalDateTime startDate, LocalDateTime endDate);
}

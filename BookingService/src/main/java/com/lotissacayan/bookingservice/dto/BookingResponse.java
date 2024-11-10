package com.lotissacayan.bookingservice.dto;
import java.time.LocalDate;

public record BookingResponse(

        String id,
        String roomId,
        String userId,
        LocalDate startDate,
        LocalDate endDate,
        String purpose

) {
}

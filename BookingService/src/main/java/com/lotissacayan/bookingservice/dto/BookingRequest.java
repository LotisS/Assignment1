package com.lotissacayan.bookingservice.dto;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public record BookingRequest(
        @NotNull String userId,
        @NotNull String roomId,
        @NotNull LocalDate startDate,
        @NotNull LocalDate endDate,
        String purpose
) {
}

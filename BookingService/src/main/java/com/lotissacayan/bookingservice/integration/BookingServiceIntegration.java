package com.lotissacayan.bookingservice.integration;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class BookingServiceIntegration {

    private MockMvc mockMvc;


    @Test
    public void createBooking() throws Exception{
        String bookingCreated = "{\"userId\": \"user1\",\"roomId\": \"room1\",\startDate\": \"2024-11-07T10:00:00\", \"endDate\": \"2024-11-07T12:00:00\", \"purpose\":\"Study\"}";


        mockMvc.perform(post("/api/bookings")
                .contentType(MediaType.APPLICATION_JSON)
                .content(bookingCreated))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.usrId").value("user1"))
                .andExpect(jsonPath("$.roomId").value("room1"));
    }
}

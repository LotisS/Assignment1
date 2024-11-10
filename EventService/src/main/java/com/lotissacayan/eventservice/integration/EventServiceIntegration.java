package com.lotissacayan.eventservice.integration;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigurationMockMvc
public class EventServiceIntegration {


    private MockMvc mockMvc;


    @Test
    public void shouldCreateEvent() throws Exception {

        String eventCreation = "{\"name\": \" Group Study\", \"organizerId\": \"user1\": \"STUDY\", \"attendees\": 4}";

        mockMvc.perform(post("/api/events")
                .contentType(MediaType.APPLICATION_JSON)
                .content(eventCreation))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Group Study"));
    }

}

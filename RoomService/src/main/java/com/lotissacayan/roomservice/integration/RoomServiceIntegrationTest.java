package com.lotissacayan.roomservice.integration;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static java.lang.reflect.Array.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RoomServiceIntegrationTest {



    private MockMvc mockMvc;


    @Test
    public void shouldCreateRoom() throws Exception {
        String roomAvailable = " {\"name\":\" Study Room A\",\"capacity\": 20 }";


        mockMvc.perform(post("/api/rooms")
                .contentType(MediaType.APPLICATION_JSON)
                .content(roomAvailable))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Study Room A"))
                .andExpect(jsonPath("$.capacity").value(20));

    }

    @Test
    public void shouldGetRoomById() throws Exception{
        String roomId = "1" ;

        mockMvc.perform((org.springframework.test.web.servlet.RequestBuilder) get("/api/rooms/{id}", Integer.parseInt(roomId)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(roomId));
    }

}

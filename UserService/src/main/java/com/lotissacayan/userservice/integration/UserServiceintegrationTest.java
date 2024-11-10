package com.lotissacayan.userservice.integration;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.web.servlet.MockMvc;

import static java.lang.reflect.Array.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserServiceintegrationTest {

    private MockMvc mockMvc;


    @Test
    public void shouldCreateUser() throws Exception {
        String userInquiry = "{\"name\": \"Monina Smith\",\"email\": \"moninas@lotissacayan.com\",\"role\": \"USER\" }";


        mockMvc.perform(post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(userInquiry))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Monina Smith"))
                .andExpect(jsonPath("$.role").value("USER"));

    }

    @Test
    public void shouldGetUserRole() throws Exception {
        String userId = "someUserId";

        mockMvc.perform((org.springframework.test.web.servlet.RequestBuilder) get("/api/users/{id}", Integer.parseInt(userId)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.role").exists());

    }
}

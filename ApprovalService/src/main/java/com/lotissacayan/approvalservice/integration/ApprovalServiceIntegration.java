package com.lotissacayan.approvalservice.integration;

import com.lotissacayan.eventservice.integration.AutoConfigurationMockMvc;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigurationMockMvc
public class ApprovalServiceIntegration {

    private MockMvc mockMvc;

    @Test
    public void ApprovalSubmissionRequest() throws Exception {
        String approvalSubmissionRequest = "{\"eventId\": \"event1\" , \"requestedBy\": \"user1\" }";

        mockMvc.perform(post("/api/approvals/request")
                .contentType(MediaType.APPLICATION_JSON)
                .content(approvalSubmissionRequest))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.eventId").value("APPROVED"))
                .andExpect(jsonPath("$.status").value("staff1"));
    }
}

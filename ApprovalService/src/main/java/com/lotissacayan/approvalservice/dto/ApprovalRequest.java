package com.lotissacayan.approvalservice.dto;

public class ApprovalRequest {
    private String approvalId;
    private String approvedById;

    public String getEventId() {

        return approvalId;
    }

    public String getRequestBy() {
        return approvedById;
    }
}

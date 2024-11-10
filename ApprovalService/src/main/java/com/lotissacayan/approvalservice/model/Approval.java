package com.lotissacayan.approvalservice.model;

import java.time.LocalDateTime;

public class Approval {

    private String id;
    private String eventId;
    private String requestBy;
    private String status;
    private String reason;
    private String checkedById;
    private LocalDateTime checkingIn;

    public void setEventId(String eventId) {
    }

    public void setRequestBy(String requestBy) {
    }

    public void setStatus(String pending) {
    }

    public void setCheckingIn(LocalDateTime now) {
    }

    public void setCheckedById(String checkedById) {
    }

    public Approval save(Approval approval) {
    }

    public void setComments(String reason) {

    }
}

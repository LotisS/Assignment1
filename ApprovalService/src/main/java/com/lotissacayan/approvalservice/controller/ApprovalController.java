package com.lotissacayan.approvalservice.controller;

import com.lotissacayan.approvalservice.dto.ApprovalRequest;
import com.lotissacayan.approvalservice.model.Approval;
import com.lotissacayan.approvalservice.service.ApprovalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/approval")
public class ApprovalController {

    private final ApprovalService approvalService;


    public ApprovalController(ApprovalService approvalService){
        this.approvalService = approvalService;
    }

    @PostMapping("/request")
    public ResponseEntity<Approval> requestApproval(@RequestBody ApprovalRequest dto){
        Approval approval = approvalService.createApproval(dto.getEventId(), dto.getRequestBy());
        return ResponseEntity.ok(approval);
    }
}

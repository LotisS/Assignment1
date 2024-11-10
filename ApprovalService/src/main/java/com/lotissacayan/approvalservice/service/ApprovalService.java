package com.lotissacayan.approvalservice.service;

import com.lotissacayan.approvalservice.model.Approval;
import com.lotissacayan.userservice.model.Role;
import com.lotissacayan.approvalservice.repository.ApprovalRepository;
import com.lotissacayan.userservice.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;


@Service
public class ApprovalService {


    private final ApprovalRepository approvalRepository;

    private final UserService userService;
    private final RestTemplate restTemplate;

    @Value("${eventservice.url}")
    private String eventServiceUrl;

    @Value("${userservice.url}")
    private String userServiceUrl;

    public ApprovalService(ApprovalRepository approvalRepository, UserService userService, RestTemplate restTemplate) {
        this.approvalRepository = approvalRepository;
        this.userService = userService;

        this.restTemplate = restTemplate;
    }

    public Approval createApproval(String eventId, String requestBy) {
        Approval approval = new Approval();
        approval.setEventId(eventId);
        approval.setRequestBy(requestBy);
        approval.setStatus("PENDING");
        approval.setCheckingIn(LocalDateTime.now());
        return approvalRepository.save(approval);
    }


    public Approval checkerApproval(String approvalId, String checkedById, String status, String reason) throws AccessDeniedException {
        User checker = userService.getUserbyId(checkedById);

        boolean isStaff = checker.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .anyMatch(role -> role.equals("ROLE_STAFF"));


        if (!isStaff){

            throw new AccessDeniedException("Only staff can check the approval");
        }

        Approval approval = approvalRepository.findById(approvalId)
                .orElseThrow(() -> new EntityNotFoundException("Approval not found!"));
        approval.setStatus(status);
        approval.setCheckedById(checkedById);
        approval.setComments(reason);
        approval.setCheckingIn(LocalDateTime.now());
        return approval.save(approval);
    }


}

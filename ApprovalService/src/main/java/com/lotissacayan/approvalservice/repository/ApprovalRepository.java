package com.lotissacayan.approvalservice.repository;

import com.lotissacayan.approvalservice.model.Approval;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public class ApprovalRepository extends MongoRepository<Approval, String > {
    List<Approval> findByStatus(String status );

}

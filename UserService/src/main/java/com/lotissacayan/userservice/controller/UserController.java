package com.lotissacayan.userservice.controller;


import com.lotissacayan.userservice.model.User;
import com.lotissacayan.userservice.service.UserService;
import jdk.jfr.Event;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {


    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserDetails(@PathVariable Long userId){
        User user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }

    @PreAuthorize("hasRole('STAFF')")
    @PostMapping("/approveEvent")
    public ResponseEntity<String> approveEvent(@RequestBody Event event) {
        return new ResponseEntity<>("Event Approved", HttpStatus.OK);
    }

    @GetMapping("/{userId}/role")
    public ResponseEntity<String> getUserRole(@PathVariable Long userId){
        String role = userService.getUserRole(userId);
        return ResponseEntity.ok(role);
    }

}

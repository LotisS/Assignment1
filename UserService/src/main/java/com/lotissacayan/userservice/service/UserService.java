package com.lotissacayan.userservice.service;

import com.lotissacayan.userservice.model.Role;
import com.lotissacayan.userservice.model.User;
import com.lotissacayan.userservice.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;

    }


    public User createUser(User user) {

        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public List <User>  getUsersByRole(Role role){
        return userRepository.findByRole(String.valueOf(role));
    }


    public User getUserById(Long checkedById) {
        User user = userRepository.findById(checkedById)
                .orElseThrow(() -> new RuntimeException("User not found :" + checkedById));


        Arrays.stream(Role.values()).forEach(role -> System.out.println(role.getDisplayName()));

        return user;
    }

    public String getUserRole(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException(("User not found" + userId));
        return user.getRole().name();
    }


}

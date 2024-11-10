package com.lotissacayan.userservice.repository;

import com.lotissacayan.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lotissacayan.userservice.model.Role;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository  extends JpaRepository<User, Long> {

    List<User> findByRole(String role);

    Optional<User> findByEmail(String email);

    User save(User user);
}

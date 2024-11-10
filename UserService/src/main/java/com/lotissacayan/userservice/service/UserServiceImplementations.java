package com.lotissacayan.userservice.service;

import com.lotissacayan.userservice.model.User;
import com.lotissacayan.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;


@Service
public class UserServiceImplementations  implements  UserDetailsService {


    private final UserRepository userRepository;

    public UserServiceImplementations(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadByUsername(String username) throws UsernameFoundException {
        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found!"));

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole().name()))

        );
    }




    }
}

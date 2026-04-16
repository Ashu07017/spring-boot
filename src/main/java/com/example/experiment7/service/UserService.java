package com.example.experiment7.service;

import com.example.experiment7.entity.User;
import com.example.experiment7.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            User user = userRepository.findByUsername(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));

            UserBuilder builder = org.springframework.security.core.userdetails.User
                    .withUsername(user.getUsername());

            builder.password(user.getPassword());

            // 🔥 IMPORTANT: remove ROLE_ prefix
            builder.roles(user.getRole().replace("ROLE_", ""));

            return builder.build();
        };
    }
}
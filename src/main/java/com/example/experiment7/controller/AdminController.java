package com.example.experiment7.controller;

import com.example.experiment7.entity.User;
import com.example.experiment7.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin") // 🔥 base path
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    // ✅ EXISTING
    @GetMapping("/dashboard")
    public String dashboard() {
        return "Welcome, admin";
    }

    // 🔥 NEW — GET ALL USERS
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
package com.example.experiment7.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublicController {

    @GetMapping("/api/public/hello")
    public String hello() {
        return "This is a public endpoint";
    }
}
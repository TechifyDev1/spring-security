package com.qudus.springsec.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class HelloController {
    
    @GetMapping("/")
    public String greet(HttpServletRequest request) {
        return "Hello, Spring boot " + request.getSession().getId();
    }
}

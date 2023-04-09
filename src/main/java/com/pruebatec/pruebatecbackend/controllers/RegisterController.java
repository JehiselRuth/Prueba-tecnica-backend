package com.pruebatec.pruebatecbackend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pruebatec.pruebatecbackend.models.User;
import com.pruebatec.pruebatecbackend.services.UserServiceImpl;


@RestController
@RequestMapping("/api/")
public class RegisterController {
    
    UserServiceImpl userService;

    public RegisterController(UserServiceImpl userService){
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        try {
            userService.store(user);
            return ResponseEntity.status(201).body("Register successfully");
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e + " Register failed");
        }
    }
}


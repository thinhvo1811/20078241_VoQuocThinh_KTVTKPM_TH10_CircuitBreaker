package com.example.user_service.controllers;


import com.example.user_service.models.User;
import com.example.user_service.repositories.UserRepository;
import com.example.user_service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @GetMapping("/user-service/read")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/user-service/create")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/user-service/read/product")
    public List<Map<String, Object>> getAllProduct() {
        return userService.getAllProduct();
    }
}

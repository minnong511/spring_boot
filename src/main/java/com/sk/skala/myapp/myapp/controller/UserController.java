package com.sk.skala.myapp.myapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sk.skala.myapp.myapp.domain.User;
import com.sk.skala.myapp.myapp.service.UserService;

@RestController
@RequestMapping("/api")

public class UserController {
    private final UserService userService; 

    public UserController(UserService userService) {
        this.userService = userService; 
    }

    @GetMapping("/users")
    public List<User> getAllusers(){
        return userService.getAllusers(); 
    }

    
    
}

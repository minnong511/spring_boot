package com.sk.skala.myapp.myapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sk.skala.myapp.myapp.domain.User;
import com.sk.skala.myapp.myapp.service.UserService;

// HTTP 요청 받기 
// Service 호출 
// 결과 반환 

@RestController // controller 로 인식 
@RequestMapping("/api") // api 기본 주소로 설정 

public class UserController {

    private final UserService userService; 


    // Service 호출 
    public UserController(UserService userService) {
        this.userService = userService; 
    }

    @GetMapping("/users")
    public List<User> getAllusers(){
        return userService.getAllusers(); 
    }
    // 결과 반환 
    
    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
    }
}

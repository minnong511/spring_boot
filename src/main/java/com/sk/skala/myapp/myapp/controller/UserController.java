package com.sk.skala.myapp.myapp.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sk.skala.myapp.myapp.domain.User;
import com.sk.skala.myapp.myapp.dto.UserRequest;
import com.sk.skala.myapp.myapp.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

// HTTP 요청 받기 
// Service 호출 
// 결과 반환 
@Slf4j
@RestController // controller 로 인식 
@RequestMapping("/api") // api 기본 주소로 설정 
@RequiredArgsConstructor


public class UserController {

    private final UserService userService; // 호출할 

    // Service 호출 
    @GetMapping("/users")
    public List<User> getAllusers(@RequestParam Optional<String> name){
        log.info("나는 바보다 히히 getAllUsers called");
        log.debug("getAllUsers called with name filter: {}", name.orElse("none"));
        return userService.getAllusers(); 
    }

    // id getUserById
    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable long  id){
        return userService.getUserById(id); 
    }


    // 결과 반환 
    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(
            @Valid @RequestBody UserRequest request
    ) {
        return userService.createUser(request);
    }

}


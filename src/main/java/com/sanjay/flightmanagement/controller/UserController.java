package com.sanjay.flightmanagement.controller;

import com.sanjay.flightmanagement.dto.request.UserRequestDto;
import com.sanjay.flightmanagement.dto.response.UserResponseDto;
import com.sanjay.flightmanagement.entity.User;
import com.sanjay.flightmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody UserRequestDto requestDto) {
        return userService.register(requestDto);
    }

    @GetMapping
    public List<UserResponseDto> getUser() {
        return userService.getUser();
    }

    @PutMapping("/{id}")
    public UserResponseDto updatePassword(@PathVariable Long id, @RequestBody UserRequestDto requestDto) {
        return userService.updatePassword(id, requestDto);
    }


}

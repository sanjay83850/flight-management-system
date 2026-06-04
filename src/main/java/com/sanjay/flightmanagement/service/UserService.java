package com.sanjay.flightmanagement.service;

import com.sanjay.flightmanagement.dto.request.UserRequestDto;
import com.sanjay.flightmanagement.dto.response.UserResponseDto;
import com.sanjay.flightmanagement.entity.User;

import java.util.List;

public interface UserService {

    public UserResponseDto register(UserRequestDto requestDto);

    public List<UserResponseDto> getUser();

    public UserResponseDto updatePassword(Long id, UserRequestDto requestDto);

    String verify(UserRequestDto requestDto);
}

package com.sanjay.flightmanagement.mapper;

import com.sanjay.flightmanagement.dto.request.UserRequestDto;
import com.sanjay.flightmanagement.dto.response.UserResponseDto;
import com.sanjay.flightmanagement.entity.User;
import com.sanjay.flightmanagement.enums.Role;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserMapper {

    public static User mapToUser(UserRequestDto requestDto) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User user = new User();

        user.setUserName(requestDto.getUserName());
        user.setUser_email(requestDto.getUser_email());
        user.setUser_password(encoder.encode(requestDto.getUser_password()));
        user.setRole(Role.USER);

        return user;
    }

    public static UserResponseDto mapToUserResponseDto(User user) {
        UserResponseDto dto = new UserResponseDto();

        dto.setUser_id(user.getUser_id());
        dto.setUserName(user.getUserName());
        dto.setUser_email(user.getUser_email());
        dto.setUser_password(user.getUser_password());
        dto.setRole(user.getRole());

        return dto;
    }

    public static void updateUser(UserRequestDto requestDto, User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        if(requestDto.getUserName() != null) {
            user.setUserName(requestDto.getUserName());
        }

        if(requestDto.getUser_email() != null) {
            user.setUser_email(requestDto.getUser_email());
        }

        if(requestDto.getUser_password() != null) {
            user.setUser_password(encoder.encode(requestDto.getUser_password()));
        }

        if(requestDto.getRole() != null) {
            user.setRole(requestDto.getRole());
        }

    }
}

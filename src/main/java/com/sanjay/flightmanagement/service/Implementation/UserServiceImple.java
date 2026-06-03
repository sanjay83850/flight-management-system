package com.sanjay.flightmanagement.service.Implementation;

import com.sanjay.flightmanagement.dto.request.FlightRequestDto;
import com.sanjay.flightmanagement.dto.request.UserRequestDto;
import com.sanjay.flightmanagement.dto.response.FlightResponseDto;
import com.sanjay.flightmanagement.dto.response.UserResponseDto;
import com.sanjay.flightmanagement.entity.Flight;
import com.sanjay.flightmanagement.entity.User;
import com.sanjay.flightmanagement.exception.FlightNotFoundException;
import com.sanjay.flightmanagement.mapper.FlightMapper;
import com.sanjay.flightmanagement.mapper.UserMapper;
import com.sanjay.flightmanagement.repository.UserRepository;
import com.sanjay.flightmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImple implements UserService {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Override
    public UserResponseDto register(UserRequestDto requestDto) {

        //DTO to Entity
        User user = UserMapper.mapToUser(requestDto);

        User savedUser = userRepository.save(user);

        //Entity to DTO
        return UserMapper.mapToUserResponseDto(savedUser);
    }

    @Override
    public List<UserResponseDto> getUser() {
        List<User> users = userRepository.findAll();

        return users.stream()
                .map(UserMapper::mapToUserResponseDto)
                .toList();
    }

    @Override
    public UserResponseDto updatePassword(Long id, UserRequestDto requestDto) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        UserMapper.updateUser(requestDto, existingUser);

        User updatedUser = userRepository.save(existingUser);

        return UserMapper.mapToUserResponseDto(updatedUser);
    }
}

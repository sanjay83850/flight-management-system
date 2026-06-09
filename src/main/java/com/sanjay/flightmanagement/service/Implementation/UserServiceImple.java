package com.sanjay.flightmanagement.service.Implementation;

import com.sanjay.flightmanagement.config.JWTService;
import com.sanjay.flightmanagement.dto.request.UserRequestDto;
import com.sanjay.flightmanagement.dto.response.UserResponseDto;
import com.sanjay.flightmanagement.entity.User;
import com.sanjay.flightmanagement.exception.UserNotFoundException;
import com.sanjay.flightmanagement.mapper.UserMapper;
import com.sanjay.flightmanagement.repository.UserRepository;
import com.sanjay.flightmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImple implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JWTService jwtService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Autowired
    private AuthenticationManager authManager;

    @Override
    public UserResponseDto register(UserRequestDto requestDto) {

        //DTO to Entity
        User user = UserMapper.mapToUser(requestDto);

        User savedUser = userRepository.save(user);

        //Entity to DTO
        return UserMapper.mapToUserResponseDto(savedUser);
    }

    @Override
    public String verify(UserRequestDto requestDto) {
        Authentication authentication =
                authManager.authenticate(new UsernamePasswordAuthenticationToken(requestDto.getUserName(), requestDto.getUser_password()));

        if(authentication.isAuthenticated())
            return jwtService.generateToken(requestDto.getUserName());

        return "Fail";
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
                        new UserNotFoundException("User not found"));

        UserMapper.updateUser(requestDto, existingUser);

        User updatedUser = userRepository.save(existingUser);

        return UserMapper.mapToUserResponseDto(updatedUser);
    }
}

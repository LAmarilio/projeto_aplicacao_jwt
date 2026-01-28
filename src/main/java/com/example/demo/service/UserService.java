package com.example.demo.service;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.LoginResponse;
import com.example.demo.dto.UserRequest;
import com.example.demo.dto.UserResponse;
import com.example.demo.exception.UserAlreadyExistsException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private UserResponse toResponse(User user) {
        UserResponse dto = new UserResponse();

        dto.setFullName(user.getFullName());
        dto.setRole(user.getRole());
        return dto;
    }

    public UserResponse createUser(UserRequest dto) {
        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new UserAlreadyExistsException("Já existe um usuário com este e-mail");
        }
        User user = new User();
        user.setFullName(dto.getFullName());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRole(dto.getRole());

        User saved = userRepository.save(user);

        return toResponse(saved);
    }

    public LoginResponse effectiveLogin(LoginRequest dto) {
        User user = userRepository.findUserByEmail(dto.getEmail());
        if (user != null && passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            LoginResponse res = new LoginResponse(user.getId(), user.getFullName(), JwtUtil.generateToken(user.getEmail(), user.getRole()));
            return res;
        } else if (user != null) {
            throw new ValidationException("A senha não coincide com a registrada!");
        } else {
            throw new UserNotFoundException("O usuário com este e-mail não foi localizado.");
        }
    }
}

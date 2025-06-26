package com.secureecomerce.secureEcommerce.service.impl;

import com.secureecomerce.secureEcommerce.dto.UserDto;
import com.secureecomerce.secureEcommerce.dto.UserLoginDto;
import com.secureecomerce.secureEcommerce.dto.UserRegistrationDto;
import com.secureecomerce.secureEcommerce.entity.User;
import com.secureecomerce.secureEcommerce.exception.OurException;
import com.secureecomerce.secureEcommerce.mapper.UserMapper;
import com.secureecomerce.secureEcommerce.repository.UserRepo;
import com.secureecomerce.secureEcommerce.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UserDto register(UserRegistrationDto registrationDto) {

        log.info("Registration attempt for user: {}", registrationDto.getEmail());

        if (userRepo.existsByEmail(registrationDto.getEmail())){
            throw new OurException("Email already exists");
        }
        User user = User.builder()
                .username(registrationDto.getUsername())
                .email(registrationDto.getEmail())
                .password(passwordEncoder.encode(registrationDto.getPassword()))
                .build();

        return userMapper.toDto(userRepo.save(user));
    }

    @Override
    public UserDto login(UserLoginDto loginDto) {
        log.info("Login attempt for user: {}", loginDto.getUsername());

        User user = userRepo.findByUsername(loginDto.getUsername())
                .orElseThrow(() -> new OurException("User not found with username: " + loginDto.getUsername()));

        if (user.isBlocked()){
            if (user.getBlockedUntil().isAfter(LocalDateTime.now())){
                throw new OurException("User is blocked until " + user.getBlockedUntil());
            } else {
                user.setBlocked(false);
                user.setFailedLoginAttempts(0);
                user.setBlockedUntil(null);
            }
        }
        if (!passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
            int attempts = user.getFailedLoginAttempts() + 1;
            user.setFailedLoginAttempts(attempts);
            user.setLastLoginAttempt(LocalDateTime.now());

            if (attempts >= 3){
                user.setBlocked(true);
                user.setBlockedUntil(LocalDateTime.now().plusMinutes(10)); // Block for 10 minutes
                userRepo.save(user);
                throw new OurException("User is blocked due to too many failed login attempts. Try again later.");
            }
            userRepo.save(user);
            throw new OurException("Invalid password. Attempt " + attempts + " of 3.");
        }

        user.setFailedLoginAttempts(0);
        user.setBlocked(false);
        user.setBlockedUntil(null);
        userRepo.save(user);

        return userMapper.toDto(user);
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new OurException("User not found with ID: " + userId));
        return userMapper.toDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepo.findAll()
                .stream()
                .map(userMapper::toDto)
                .toList();
    }
}

package com.secureecomerce.secureEcommerce.service.impl;

import com.secureecomerce.secureEcommerce.dto.UserDto;
import com.secureecomerce.secureEcommerce.dto.UserLoginDto;
import com.secureecomerce.secureEcommerce.dto.UserRegistrationDto;
import com.secureecomerce.secureEcommerce.mapper.UserMapper;
import com.secureecomerce.secureEcommerce.repository.UserRepo;
import com.secureecomerce.secureEcommerce.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final UserMapper userMapper;

    @Override
    public UserDto register(UserRegistrationDto registrationDto) {
        return null;
    }

    @Override
    public UserDto login(UserLoginDto loginDto) {
        return null;
    }

    @Override
    public UserDto getUserById(Long userId) {
        return null;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return List.of();
    }
}

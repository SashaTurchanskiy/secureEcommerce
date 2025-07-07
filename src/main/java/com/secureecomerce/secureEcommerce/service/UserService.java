package com.secureecomerce.secureEcommerce.service;

import com.secureecomerce.secureEcommerce.dto.AuthResponseDto;
import com.secureecomerce.secureEcommerce.dto.UserDto;
import com.secureecomerce.secureEcommerce.dto.UserLoginDto;
import com.secureecomerce.secureEcommerce.dto.UserRegistrationDto;

import java.util.List;

public interface UserService {

    AuthResponseDto register(UserRegistrationDto registrationDto);
    AuthResponseDto login(UserLoginDto loginDto);
    UserDto getUserById(Long userId);
    List<UserDto> getAllUsers();

}

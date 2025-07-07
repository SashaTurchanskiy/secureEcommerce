package com.secureecomerce.secureEcommerce.controller;

import com.secureecomerce.secureEcommerce.dto.AuthResponseDto;
import com.secureecomerce.secureEcommerce.dto.UserDto;
import com.secureecomerce.secureEcommerce.dto.UserLoginDto;
import com.secureecomerce.secureEcommerce.dto.UserRegistrationDto;
import com.secureecomerce.secureEcommerce.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponseDto> register(@RequestBody UserRegistrationDto user){
        return ResponseEntity.ok(userService.register(user));
    }
    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody UserLoginDto loginDto){
        AuthResponseDto authResponse = userService.login(loginDto);
        return ResponseEntity.ok(authResponse);
    }
 }

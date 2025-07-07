package com.secureecomerce.secureEcommerce.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class AuthResponseDto {

    private String accessToken;
    private LocalDateTime expiresAt;
    private String username;
    private String role;
    private Long userId;
}

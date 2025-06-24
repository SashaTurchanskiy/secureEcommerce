package com.secureecomerce.secureEcommerce.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.secureecomerce.secureEcommerce.entity.enums.Role;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {

    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String username;
    private String password;
    private String email;
    private Role role;
    private List<OrderDto> orders;
}

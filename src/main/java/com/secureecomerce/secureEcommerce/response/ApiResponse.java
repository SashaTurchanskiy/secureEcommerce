package com.secureecomerce.secureEcommerce.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    private int status;
    private String message;
    private final LocalDateTime timestamp = LocalDateTime.now();

    private T data;

    private Integer totalPage;
    private Long totalElement;

    private String token;
    private String role;
    private String expirationTime;

}

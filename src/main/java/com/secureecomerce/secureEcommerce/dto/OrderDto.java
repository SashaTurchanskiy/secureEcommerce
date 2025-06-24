package com.secureecomerce.secureEcommerce.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDto {

    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String status;
    private UserDto userDto;
    private List<ProductDto> products;

}

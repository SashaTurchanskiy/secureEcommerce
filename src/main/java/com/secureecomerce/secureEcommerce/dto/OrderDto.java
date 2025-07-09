package com.secureecomerce.secureEcommerce.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDto {

    private Long id;
    private Long userId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String status;
    private BigDecimal totalAmount;
    private LocalDateTime orderDate;
    private List<OrderItemDto> orderItems;
    private List<ProductDto> products;


}

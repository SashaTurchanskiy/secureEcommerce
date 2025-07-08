package com.secureecomerce.secureEcommerce.service;


import com.secureecomerce.secureEcommerce.dto.OrderDto;

import java.util.List;

public interface OrderService {
    List<OrderDto> getOrdersForUser(Long userId);
    OrderDto getOrderById(Long orderId);
    void cancelOrder(Long orderId);
}

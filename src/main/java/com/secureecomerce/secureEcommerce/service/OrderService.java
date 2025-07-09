package com.secureecomerce.secureEcommerce.service;


import com.secureecomerce.secureEcommerce.dto.OrderDto;
import com.secureecomerce.secureEcommerce.entity.Product;
import com.secureecomerce.secureEcommerce.entity.User;

import java.util.List;

public interface OrderService {
   OrderDto createOrder(User user, Product product, int quantity);
   OrderDto getOrderById(Long orderId);
   OrderDto getOrderByUser(User user);
   OrderDto updateOrder(Long orderId, String status);
   List<OrderDto> getAllOrders();
   void deleteOrder(Long orderId);

}

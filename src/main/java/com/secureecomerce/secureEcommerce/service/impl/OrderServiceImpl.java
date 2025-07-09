package com.secureecomerce.secureEcommerce.service.impl;

import com.secureecomerce.secureEcommerce.dto.OrderDto;
import com.secureecomerce.secureEcommerce.entity.Order;
import com.secureecomerce.secureEcommerce.entity.Product;
import com.secureecomerce.secureEcommerce.entity.User;
import com.secureecomerce.secureEcommerce.exception.OurException;
import com.secureecomerce.secureEcommerce.mapper.OrderMapper;
import com.secureecomerce.secureEcommerce.repository.OrderRepo;
import com.secureecomerce.secureEcommerce.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;
    private final OrderMapper orderMapper;


    @Override
    public OrderDto createOrder(User user, Product product, int quantity) {
        return null;
    }

    @Override
    public OrderDto getOrderById(Long orderId) {
        Order order = orderRepo.findById(orderId)
                .orElseThrow(()-> new OurException("Order not found with id: " + orderId));
        return orderMapper.toDto(order);
    }

    @Override
    public OrderDto getOrderByUser(User user) {

        return null;
    }

    @Override
    public OrderDto updateOrder(Long orderId, String status) {
        return null;
    }

    @Override
    public List<OrderDto> getAllOrders() {
    return orderRepo.findAll()
                .stream()
                .map(orderMapper::toDto)
                .toList();
    }

    @Override
    public void deleteOrder(Long orderId) {
        Order order = orderRepo.findById(orderId)
                .orElseThrow(()-> new OurException("Order not found with id: " + orderId));
        orderRepo.delete(order);
    }
}

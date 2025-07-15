package com.secureecomerce.secureEcommerce.service.impl;

import com.secureecomerce.secureEcommerce.entity.Order;
import com.secureecomerce.secureEcommerce.entity.OrderItem;
import com.secureecomerce.secureEcommerce.entity.Product;
import com.secureecomerce.secureEcommerce.repository.OrderItemRepo;
import com.secureecomerce.secureEcommerce.repository.OrderRepo;
import com.secureecomerce.secureEcommerce.repository.ProductRepo;
import com.secureecomerce.secureEcommerce.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepo orderItemRepo;
    private final OrderRepo orderRepo;
    private final ProductRepo productRepo;

    @Override
    public OrderItem createOrderItem(Long orderId, Long productId, int quantity) {
        Order order = orderRepo.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + orderId));
        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));

        OrderItem orderItem = new OrderItem();
        orderItem.setOrder(order);
        orderItem.setProduct(product);
        orderItem.setQuantity(quantity);
        orderItem.setPrice(product.getPrice().multiply(BigDecimal.valueOf(quantity)));

        return orderItemRepo.save(orderItem);
    }

    @Override
    public void deleteOrderItem(Long orderItemId) {
        orderItemRepo.deleteById(orderItemId);
    }

    @Override
    public List<OrderItem> getOrderItemsByOrder(Long orderId) {
        Order order = orderRepo.findById(orderId)
                .orElseThrow(()-> new RuntimeException("Order not found with id: " + orderId));
        return orderItemRepo.findAllByOrder(order);
    }
}

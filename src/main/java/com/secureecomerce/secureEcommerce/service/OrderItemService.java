package com.secureecomerce.secureEcommerce.service;

import com.secureecomerce.secureEcommerce.entity.OrderItem;

import java.util.List;

public interface OrderItemService {
    OrderItem createOrderItem(Long orderId, Long productId, int quantity);
    void deleteOrderItem(Long orderItemId);
    List<OrderItem> getOrderItemsByOrder(Long orderId);
}

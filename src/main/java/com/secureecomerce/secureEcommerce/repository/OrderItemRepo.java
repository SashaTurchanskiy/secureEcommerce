package com.secureecomerce.secureEcommerce.repository;

import com.secureecomerce.secureEcommerce.entity.Order;
import com.secureecomerce.secureEcommerce.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderItemRepo extends JpaRepository<OrderItem, Long> {

    Optional<OrderItem> findById(Long id);
    List<OrderItem> findAllByOrder(Order order);
}

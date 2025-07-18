package com.secureecomerce.secureEcommerce.repository;

import com.secureecomerce.secureEcommerce.entity.Order;
import com.secureecomerce.secureEcommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Long> {
    List<Order> findByUserId(Long userId);

    List<Order> findAllByUser(User user);

}

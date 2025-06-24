package com.secureecomerce.secureEcommerce.repository;

import com.secureecomerce.secureEcommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long> {

    List<Product> findByNameContainingIgnoreCase(String keyword);

}

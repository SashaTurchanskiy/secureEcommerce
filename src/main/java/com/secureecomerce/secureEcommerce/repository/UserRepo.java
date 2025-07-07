package com.secureecomerce.secureEcommerce.repository;

import com.secureecomerce.secureEcommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
    //Optional<User> findByEmail(String email);
}

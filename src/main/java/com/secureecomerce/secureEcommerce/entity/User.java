package com.secureecomerce.secureEcommerce.entity;

import com.secureecomerce.secureEcommerce.entity.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "users")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User extends BaseEntity {

    @NotBlank(message = "Username is required")
    private String username;
    @NotBlank(message = "Password is required")
    private String password;
    @NotBlank(message = "Email is required")
    @Column(unique = true)
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;

    private int failedLoginAttempts;
    private LocalDateTime lastLoginAttempt;
    private boolean isBlocked;
    private LocalDateTime blockedUntil;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;


}

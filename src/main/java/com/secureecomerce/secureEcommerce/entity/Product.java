package com.secureecomerce.secureEcommerce.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Table(name = "products")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseEntity{


    @NotBlank(message = "Product name is required")
    private String name;
    private String description;
    private BigDecimal price;

    @ManyToMany(mappedBy = "products")
    private List<Order> orders;
}

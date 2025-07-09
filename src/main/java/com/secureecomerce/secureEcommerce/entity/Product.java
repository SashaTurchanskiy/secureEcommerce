package com.secureecomerce.secureEcommerce.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
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
    private int inventory;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", nullable = false)
    @JsonBackReference
    private Category category;

    @ManyToMany(mappedBy = "products")
    private List<Order> orders;



}

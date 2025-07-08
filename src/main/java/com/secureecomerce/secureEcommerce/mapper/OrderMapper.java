package com.secureecomerce.secureEcommerce.mapper;

import com.secureecomerce.secureEcommerce.dto.OrderDto;
import com.secureecomerce.secureEcommerce.dto.OrderItemDto;
import com.secureecomerce.secureEcommerce.entity.Order;
import com.secureecomerce.secureEcommerce.entity.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderDto toDto(Order order);
    Order toEntity(OrderDto orderDto);
    }




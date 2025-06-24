package com.secureecomerce.secureEcommerce.mapper;

import com.secureecomerce.secureEcommerce.dto.OrderDto;
import com.secureecomerce.secureEcommerce.entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderDto toDto(Order order);
    Order toEntity(OrderDto orderDto);
}

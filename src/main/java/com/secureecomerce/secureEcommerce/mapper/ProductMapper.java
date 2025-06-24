package com.secureecomerce.secureEcommerce.mapper;

import com.secureecomerce.secureEcommerce.dto.ProductDto;
import com.secureecomerce.secureEcommerce.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDto toDto(Product product);
    Product toEntity(ProductDto productDto);
}

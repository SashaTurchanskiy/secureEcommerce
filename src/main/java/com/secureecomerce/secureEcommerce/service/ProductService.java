package com.secureecomerce.secureEcommerce.service;

import com.secureecomerce.secureEcommerce.dto.ProductDto;
import com.secureecomerce.secureEcommerce.entity.Product;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAllProducts();
    ProductDto getProductById(Long productId);
    ProductDto createProduct(ProductDto productDto);
    ProductDto updateProduct(Long productId, ProductDto productDto);
    void deleteProduct(Long productId);
}

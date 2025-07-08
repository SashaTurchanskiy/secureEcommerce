package com.secureecomerce.secureEcommerce.service.impl;

import com.secureecomerce.secureEcommerce.dto.ProductDto;
import com.secureecomerce.secureEcommerce.entity.Product;
import com.secureecomerce.secureEcommerce.exception.OurException;
import com.secureecomerce.secureEcommerce.mapper.ProductMapper;
import com.secureecomerce.secureEcommerce.repository.ProductRepo;
import com.secureecomerce.secureEcommerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;
    private final ProductMapper productMapper;

    @Override
    public List<ProductDto> getAllProducts() {
        return productRepo.findAll().stream()
                .map(productMapper::toDto)
                .toList();
    }

    @Override
    public ProductDto getProductById(Long productId) {
        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new OurException("Product not found with id: " + productId));
        return productMapper.toDto(product);
    }

    @Override
    @Transactional
    public ProductDto createProduct(ProductDto productDto) {

        log.info("Creating product: {}", productDto.getName());

        Product product = productMapper.toEntity(productDto);
        product.setCreatedAt(LocalDateTime.now());
        return productMapper.toDto(productRepo.save(product));
    }

    @Override
    @Transactional
    public ProductDto updateProduct(Long productId, ProductDto productDto) {

        log.info("Updating product {} with ID: {}", productDto.getName(), productId);

        Product existing = productRepo.findById(productId)
                .orElseThrow(()-> new OurException("Product not found with id: " + productId));
        existing.setName(productDto.getName());
        existing.setDescription(productDto.getDescription());
        existing.setPrice(productDto.getPrice());
        existing.setUpdatedAt(LocalDateTime.now());
        return productMapper.toDto(productRepo.save(existing));
    }

    @Override
    public void deleteProduct(Long productId) {
        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new OurException("Product not found with id: " + productId));
        productRepo.delete(product);

    }
}

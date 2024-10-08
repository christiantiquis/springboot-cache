package com.example.cacheexample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.cacheexample.model.Product;
import com.example.cacheexample.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Cacheable("products")  // Caches the result of this method
    public Product getProductById(Long id) {
        return productRepository.findById(id);
    }
}
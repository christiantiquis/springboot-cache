package com.example.cacheexample.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.cacheexample.model.Product;

@Repository
public class ProductRepository {

    private static final Map<Long, Product> DATABASE = new HashMap<>();

    static {
        DATABASE.put(1L, new Product(1L, "Laptop", 1200.0));
        DATABASE.put(2L, new Product(2L, "Phone", 800.0));
    }

    public Product findById(Long id) {
        // Simulate a slow database call
        simulateSlowService();
        return DATABASE.get(id);
    }

    private void simulateSlowService() {
        try {
            Thread.sleep(3000); // Simulates a delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
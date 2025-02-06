package com.example.back_order_test.repository.r2dbc;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.example.back_order_test.model.Product;

public interface ProductRepository extends ReactiveCrudRepository<Product, String> {
    
}

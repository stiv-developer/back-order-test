package com.example.back_order_test.repository.mongo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.example.back_order_test.model.Order;

public interface OrderRepository extends ReactiveMongoRepository<Order, String> {
    
}

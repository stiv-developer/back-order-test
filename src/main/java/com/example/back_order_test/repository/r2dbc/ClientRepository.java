package com.example.back_order_test.repository.r2dbc;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.example.back_order_test.model.Client;

public interface ClientRepository extends ReactiveCrudRepository<Client, String> {
}

package com.example.back_order_test.services;

import com.example.back_order_test.dto.OrderDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OrderService {

    Flux<OrderDTO> findAll();
    Mono<OrderDTO> findById(String id);
    Mono<OrderDTO> save(OrderDTO orderDTO);
    Mono<OrderDTO> update(String id, OrderDTO orderDTO);
    Mono<Void> delete(String id);

}

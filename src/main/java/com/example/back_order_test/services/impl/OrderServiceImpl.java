package com.example.back_order_test.services.impl;

import org.springframework.stereotype.Service;

import com.example.back_order_test.dto.OrderDTO;
import com.example.back_order_test.mapper.OrderMapper;
import com.example.back_order_test.repository.mongo.OrderRepository;
import com.example.back_order_test.services.OrderService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;
    private final OrderMapper mapper;

    @Override
    public Flux<OrderDTO> findAll() {
        return repository.findAll().map(mapper::toDTO);
    }

    @Override
    public Mono<OrderDTO> findById(String id) {
        return repository.findById(id).map(mapper::toDTO);
    }

    @Override
    public Mono<OrderDTO> save(OrderDTO orderDTO) {
        return repository.save(mapper.toEntity(orderDTO)).map(mapper::toDTO);
    }

    @Override
    public Mono<OrderDTO> update(String id, OrderDTO orderDTO) {
        return repository.findById(id)
        .flatMap(order -> {
            order.setNroOrder(orderDTO.getNroOrder());
            return repository.save(order);
        })
        .map(mapper::toDTO);
    }

    @Override
    public Mono<Void> delete(String id) {
        return repository.findById(id)
                .flatMap(existingOrder -> repository.delete(existingOrder));
    }
    
}

package com.example.back_order_test.controller;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.back_order_test.dto.OrderDTO;
import com.example.back_order_test.services.OrderService;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

    @GetMapping
    public Flux<OrderDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Mono<OrderDTO> findById(@PathVariable String id) {
        return service.findById(id)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found")));
    }

    @PostMapping
    public Mono<OrderDTO> save(@RequestBody OrderDTO orderDTO) {
        return service.save(orderDTO)
                .onErrorResume(
                        e -> Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error saving order")));
    }

    @PutMapping
    public Mono<OrderDTO> update(@PathVariable String id, @RequestBody OrderDTO orderDTO){
        return service.update(id, orderDTO)
        .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found")))
        .onErrorResume(e -> Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error updating orden")));
    }

    @DeleteMapping
    public Mono<Void> delete(@PathVariable String id){
        return service.delete(id)
        .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found")))
        .onErrorResume(e -> Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error deleting order")));
    }
}

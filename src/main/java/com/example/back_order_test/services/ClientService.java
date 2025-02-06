package com.example.back_order_test.services;

import com.example.back_order_test.dto.ClientDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientService {
    
    Flux<ClientDTO> findAll();
    Mono<ClientDTO> findById(String id);
    Mono<ClientDTO> save(ClientDTO clientDTO);
    Mono<ClientDTO> update(String id, ClientDTO clientDTO);
    Mono<Void> delete(String id);
}

package com.example.back_order_test.services.impl;

import org.springframework.stereotype.Service;

import com.example.back_order_test.dto.ClientDTO;
import com.example.back_order_test.mapper.ClientMapper;
import com.example.back_order_test.repository.r2dbc.ClientRepository;
import com.example.back_order_test.services.ClientService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl  implements ClientService {

    private final ClientRepository repository;
    private final ClientMapper mapper;

    @Override
    public Flux<ClientDTO> findAll() {
        return repository.findAll().map(mapper::toDTO);
    }

    @Override
    public Mono<ClientDTO> findById(String id) {
        return repository.findById(id).map(mapper::toDTO);
    }

    @Override
    public Mono<ClientDTO> save(ClientDTO clientDTO) {
        return repository.save(mapper.toEntity(clientDTO)).map(mapper::toDTO);
    }

    @Override
    public Mono<ClientDTO> update(String id, ClientDTO clientDTO) {
        return repository.findById(id)
        .flatMap(client -> {
            client.setName(clientDTO.getName());
            return repository.save(client);
        })
        .map(mapper::toDTO);
    }

    @Override
    public Mono<Void> delete(String id) {
        return repository.deleteById(id);
    }
     
}

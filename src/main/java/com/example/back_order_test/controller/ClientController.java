package com.example.back_order_test.controller;

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

import com.example.back_order_test.dto.ClientDTO;
import com.example.back_order_test.services.ClientService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService service;

    @GetMapping
    public Flux<ClientDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Mono<ClientDTO> findById(@PathVariable String id) {
        return service.findById(id)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found")));
    }

    @PostMapping
    public Mono<ClientDTO> save(@RequestBody ClientDTO clientDTO) {
        return service.save(clientDTO)
        .onErrorResume(e -> Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error saving client")));
    }

    @PutMapping
    public Mono<ClientDTO> update(@PathVariable String id, @RequestBody ClientDTO clientDTO) {
        return service.update(id, clientDTO)
        .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found")))
                .onErrorResume(e -> Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error updating client")));
    }

    @DeleteMapping
    public Mono<Void> delete(@PathVariable String id){
        return service.delete(id)
        .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found")))
        .onErrorResume(e -> Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error deleting client")));
    }
}

package com.example.back_order_test.services;

import com.example.back_order_test.dto.ProductDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
    
    Flux<ProductDTO> findAll();
    Mono<ProductDTO> findById(String id);
    Mono<ProductDTO> save(ProductDTO productDTO);
    Mono<ProductDTO> update(String id, ProductDTO productDTO);
    Mono<Void> delete(String id);

}

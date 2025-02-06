package com.example.back_order_test.services.impl;

import org.springframework.stereotype.Service;

import com.example.back_order_test.dto.ProductDTO;
import com.example.back_order_test.mapper.ProductMapper;
import com.example.back_order_test.repository.r2dbc.ProductRepository;
import com.example.back_order_test.services.ProductService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository repository;
    private final ProductMapper mapper;

    @Override
    public Flux<ProductDTO> findAll() {
        return repository.findAll().map(mapper::toDTO);
    }

    @Override
    public Mono<ProductDTO> findById(String id) {
        return repository.findById(id).map(mapper::toDTO);
    }

    @Override
    public Mono<ProductDTO> save(ProductDTO productDTO) {
        return repository.save(mapper.toEntity(productDTO)).map(mapper::toDTO);
    }

    @Override
    public Mono<ProductDTO> update(String id, ProductDTO productDTO) {
        return repository.findById(id)
        .flatMap(product -> {
            product.setName(productDTO.getName());
            return repository.save(product);
        })
        .map(mapper::toDTO);
    }

    @Override
    public Mono<Void> delete(String id) {
        return repository.deleteById(id);
    }
    
}

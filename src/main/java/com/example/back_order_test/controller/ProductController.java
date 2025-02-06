package com.example.back_order_test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.back_order_test.dto.ProductDTO;
import com.example.back_order_test.services.ProductService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    
    private final ProductService service;

    @GetMapping
    public Flux<ProductDTO> findAll(){
        return service.findAll();
    }
}

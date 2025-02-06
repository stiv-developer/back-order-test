package com.example.back_order_test.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.back_order_test.dto.ProductDTO;
import com.example.back_order_test.model.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    
    // ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDTO toDTO(Product product);
    Product toEntity(ProductDTO productDTO);
}

package com.example.back_order_test.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.back_order_test.dto.OrderDTO;
import com.example.back_order_test.model.Order;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    // OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderDTO toDTO(Order order);
    Order toEntity(OrderDTO orderDTO);
}

package com.example.back_order_test.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.back_order_test.dto.ClientDTO;
import com.example.back_order_test.model.Client;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    // ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    ClientDTO toDTO(Client client);
    Client toEntity(ClientDTO clientDTO);
    
}

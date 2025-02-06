package com.example.back_order_test.model;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.annotation.Id;

@Data
@Table("client")
public class Client {
    @Id
    private String id;

    private String name;

    private String email;
    
    private String phone;
}

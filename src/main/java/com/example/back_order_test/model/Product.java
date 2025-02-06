package com.example.back_order_test.model;

import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.annotation.Id;
import lombok.Data;

@Data
@Table("product")
public class Product {
    @Id
    private String id;
    private String name;
    private String price;
    private String stock;
}

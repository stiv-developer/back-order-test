package com.example.back_order_test.dto;
import lombok.Data;

@Data
public class ProductDTO {
    private String id;
    private String name;
    private String price;
    private String stock;
}

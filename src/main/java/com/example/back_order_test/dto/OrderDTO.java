package com.example.back_order_test.dto;

import java.util.List;

import lombok.Data;

@Data
public class OrderDTO {
   private String id;
    private String nroOrder;
    private String idClient;
    private String client;
    private List<Product> products;
    private Double total;

    @Data
    public static class Product {
        private String id;   
        private String name; 
        private String quantity;
        private String totalPrice;
    }
}


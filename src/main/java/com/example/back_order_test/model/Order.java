package com.example.back_order_test.model;

import java.util.List;
import javax.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "orders")
public class Order {
     @Id
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

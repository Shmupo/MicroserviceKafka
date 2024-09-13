package com.cogent.stock_service.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Long orderId;
    private String name;
    private int quantity;
    private double price;
}

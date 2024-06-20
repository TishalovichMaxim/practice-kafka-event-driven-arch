package by.tishalovichm.basedomains.dto;

import lombok.Data;

@Data
public class Order {

    private String orderId;

    private String name;

    private int quantity;

    private double price;

}

package by.tishalovichm.basedomains.dto;

import by.tishalovichm.basedomains.validation.OrderNameConstraint;
import by.tishalovichm.basedomains.validation.OrderPriceConstraint;
import by.tishalovichm.basedomains.validation.OrderQuantityConstraint;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "stockorders")
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    private String orderId;

    @Column(nullable = false)
    @OrderNameConstraint
    private String name;

    @OrderQuantityConstraint
    private int quantity;

    @OrderPriceConstraint
    private double price;

}

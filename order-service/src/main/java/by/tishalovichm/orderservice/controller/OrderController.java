package by.tishalovichm.orderservice.controller;

import by.tishalovichm.basedomains.dto.Order;
import by.tishalovichm.basedomains.dto.OrderEvent;
import by.tishalovichm.orderservice.kafka.OrderProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderProducer producer;

    @PostMapping
    public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
        order.setOrderId(UUID.randomUUID().toString());

        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setStatus("PENDING");
        orderEvent.setMessage("order is in pending state");
        orderEvent.setOrder(order);

        producer.sendMessage(orderEvent);

        return ResponseEntity.ok(order);
    }

}

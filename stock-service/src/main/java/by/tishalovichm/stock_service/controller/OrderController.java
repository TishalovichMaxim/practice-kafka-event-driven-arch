package by.tishalovichm.stock_service.controller;

import by.tishalovichm.basedomains.dto.Order;
import by.tishalovichm.stock_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("${stock-api.base-url.name}")
public class OrderController {

    private final OrderService service;

    @GetMapping("{id}")
    public ResponseEntity<Order> get(@PathVariable String id) {
        Order order = service.get(id).get();
        return ResponseEntity.ok(order);
    }

    @PutMapping("{id}")
    public ResponseEntity<Order> update(
            @PathVariable String id,
            @RequestBody Order order) {

        order.setOrderId(id);
        Order savedOrder = service.save(order);
        return ResponseEntity.ok(savedOrder);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

}

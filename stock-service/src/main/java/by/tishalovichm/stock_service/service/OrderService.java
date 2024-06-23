package by.tishalovichm.stock_service.service;

import by.tishalovichm.basedomains.dto.Order;
import by.tishalovichm.stock_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository repository;

    public Order save(Order order) {
        return repository.save(order);
    }

    public Optional<Order> get(String id) {
        return repository.findById(id);
    }

    public List<Order> getAll() {
        return repository.findAll();
    }

}

package by.tishalovichm.stock_service.repository;

import by.tishalovichm.basedomains.dto.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
}

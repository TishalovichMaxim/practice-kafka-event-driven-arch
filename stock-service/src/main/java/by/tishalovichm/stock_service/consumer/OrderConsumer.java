package by.tishalovichm.stock_service.consumer;

import by.tishalovichm.basedomains.dto.Order;
import by.tishalovichm.basedomains.dto.OrderEvent;
import by.tishalovichm.stock_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

    private final OrderRepository repository;

    @KafkaListener(
            topics = "${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(OrderEvent event) {
        LOGGER.info(String.format("Order saved to a database: %s", event.toString()));

        Order order = event.getOrder();
        repository.save(order);
    }

}

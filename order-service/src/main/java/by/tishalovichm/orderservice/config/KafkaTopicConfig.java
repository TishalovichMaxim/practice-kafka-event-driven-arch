package by.tishalovichm.orderservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    public NewTopic topic(@Value("${spring.kafka.topic.name}") String topicName) {
        return TopicBuilder.name(topicName)
                .build();
    }

}

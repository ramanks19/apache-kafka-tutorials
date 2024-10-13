package io.ramanksingh.kafkaService.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * This class is responsible for configuring a Kafka topic in the application.
 * */
@Configuration
public class KafkaTopicConfig {

    /**
     * This method is used to create a new Kafka topic named "aNewTopic". Using TopicBuilder a helper
     * class, it simplifies the creation of topics, allowing you to specify various configurations like
     * partition count, replication factor etc.
     * */
    @Bean
    public NewTopic kafkaTopic() {
        return TopicBuilder.name("aNewTopic")
                .build();
    }
}

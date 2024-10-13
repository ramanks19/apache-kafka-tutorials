package io.ramanksingh.kafkaService;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * It is designed to listen to Kafka topics and process incoming messages.
 * */
@Component
public class KafkaListeners {

    /**
     * This method is executed whenever a message is received from the topic "aNewTopic".
     * It uses the custom messageFactory defined in the KafkaConsumerConfig to configure the consumer.
     * */
    @KafkaListener(
            topics = "aNewTopic",
            groupId = "groupId",
            containerFactory = "messageFactory"
    )
    public void listener(Message data) {
        System.out.println("Listener received: " + data);
    }
}

package io.ramanksingh.kafkaService.config;

import io.ramanksingh.kafkaService.Message;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

/**
 * This class configures the Kafka producer for the application, enabling it to send messages to Kafka
 * topics. It specifies which Kafka brokers to connect to, the serialization format for the key and value
 * and how to create producer instances.
 * */
@Configuration
public class KafkaProducerConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    /**
     * It creates a Map<String, Object> containing Kafka producer configuration properties.
     * */
    public Map<String, Object> producerConfig() {
        Map<String, Object> props = new HashMap<String, Object>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        return props;
    }

    /**
     * Here, ProducerFactory a factory is responsible for creating Kafka producer instances.
     * The DefaultKafkaProducerFactory creates a new ProducerFactory using the producer configurations
     * defined in producerConfig().
     * */
    @Bean
    public ProducerFactory<String, Message> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfig());
    }

    /**
     * Here, kafkaTemplate a helper class is used to simplify sending messages to Kafka.
     * It internally uses the producerFactory to create producer instances when needed.
     * */
    @Bean
    public KafkaTemplate<String, Message> kafkaTemplate(
            ProducerFactory<String, Message> producerFactory
    ) {
        return new KafkaTemplate<>(producerFactory);
    }
}

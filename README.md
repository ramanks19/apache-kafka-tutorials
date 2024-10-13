# Kafka Spring Boot Application
This repository contains a simple Kafka-based application built using Spring Boot. The application demonstrates how to produce and consume messages with Kafka in a Spring Boot environment.

## Project Structure
[KafkaTopicConfig.java](https://github.com/ramanks19/apache-kafka-tutorials/blob/main/kafkaService/src/main/java/io/ramanksingh/kafkaService/config/KafkaTopicConfig.java): A class responsible for configuring a Kafka topic in the application.<br>
[KafkaProducerConfig.java](https://github.com/ramanks19/apache-kafka-tutorials/blob/main/kafkaService/src/main/java/io/ramanksingh/kafkaService/config/KafkaProducerConfig.java): Configures the Kafka producer, setting up the KafkaTemplate to send messages to a Kafka topic.<br>
[KafkaConsumerConfig.java](https://github.com/ramanks19/apache-kafka-tutorials/blob/main/kafkaService/src/main/java/io/ramanksingh/kafkaService/config/KafkaConsumerConfig.java): Configures the Kafka consumer, defining the KafkaListenerContainerFactory that will handle message consumption.<br>
[KafkaListeners.java](https://github.com/ramanks19/apache-kafka-tutorials/blob/main/kafkaService/src/main/java/io/ramanksingh/kafkaService/KafkaListeners.java): Contains the Kafka listener, which listens to messages from the specified topic and processes them.<br>
[KafkaServiceApplication.java](https://github.com/ramanks19/apache-kafka-tutorials/blob/main/kafkaService/src/main/java/io/ramanksingh/kafkaService/KafkaServiceApplication.java): The main entry point of the Spring Boot application. It contains a CommandLineRunner bean to send sample messages to the Kafka topic at runtime.<br>
[Message.java](https://github.com/ramanks19/apache-kafka-tutorials/blob/main/kafkaService/src/main/java/io/ramanksingh/kafkaService/Message.java): A record class representing the message structure with two fields: message and created.<br>
[MessageController.java](https://github.com/ramanks19/apache-kafka-tutorials/blob/main/kafkaService/src/main/java/io/ramanksingh/kafkaService/MessageController.java): A REST controller for publishing messages to Kafka. It exposes an API endpoint to send new messages to the Kafka topic.<br>
[MessageRequest](https://github.com/ramanks19/apache-kafka-tutorials/blob/main/kafkaService/src/main/java/io/ramanksingh/kafkaService/MessageRequest.java): A simple DTO used to encapsulate the data sent in HTTP requests for publishing messages.<br>

## Code Flow
**KafkaProducerConfig:** Sets up the Kafka producer, defining how to serialize messages and send them to Kafka topics.<br>
**KafkaTopicConfig:** Creates the Kafka topic (in this case, aNewTopic) where messages are sent and consumed.<br>
**KafkaConsumerConfig:** Sets up the Kafka consumer, defining how to deserialize messages from the topic and pass them to the listener.<br>
**KafkaListeners:** A Spring component that listens to messages from the aNewTopic Kafka topic and processes them in the listener() method.<br>

## Getting Started
### Prerequisites
Java 17 or later<br>
Apache Kafka<br>
Spring Boot<br>
Maven<br>

## Installation
### Clone the repository:
```
git clone https://github.com/ramanks19/apache-kafka-tutorials.git
```

### Build the project:
```
mvn clean install
```

### Run the Spring Boot application:
```
mvn spring-boot:run
```

### Kafka Setup:
Ensure that Kafka is running on your machine. Update the bootstrap-servers property in application.properties with the appropriate Kafka broker URL.
```
spring.kafka.bootstrap-servers=localhost:9092
```

### API Usage
You can use the provided API to publish messages to the Kafka topic:
```
curl --location 'localhost:8080/api/v1/messages' \
--header 'Content-Type: application/json' \
--data '{
    "message": "Api With Kafka"
}'
```

### Running Kafka in Windows machine:
1. Download the Kafka archive from the [official website](https://www.apache.org/dyn/closer.cgi?path=/kafka/3.8.0/kafka_2.13-3.8.0.tgz) and extract it using a tool like PeaZip, 7-Zip, WinRAR etc.
2. Open the cmd and go to the folder where you have extract the file:
  - Run the command to start the Zookeeper:
```
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
```
  - Open another cmd terminal and go to the folder where you have extract the file and run the command to start the Kafka broker:
```
.\bin\windows\kafka-server-start.bat .\config\server.properties
```
  - Open another terminal session and run the consumer client to read the events you just created:
```
.\bin\windows\kafka-console-consumer.bat --topic aNewTopic --from-beginning --bootstrap-server localhost:9092
```

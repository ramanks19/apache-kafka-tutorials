package io.ramanksingh.kafkaService;

/**
 * A simple DTO, used to encapsulate the data sent in HTTP requests for publishing messages
 * */
public record MessageRequest(String message) {

}

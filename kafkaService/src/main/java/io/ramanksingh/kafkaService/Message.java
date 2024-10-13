package io.ramanksingh.kafkaService;

import java.time.LocalDateTime;

/**
 * The Message class is a data container for a String and a LocalDateTime. Once the values are set during
 * the creation of a Message object, they cannot be modified, since the records are immutable.
 * */
public record Message(String message, LocalDateTime created) {

}

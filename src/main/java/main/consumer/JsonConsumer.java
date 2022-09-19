package main.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class JsonConsumer {

    @KafkaListener(topics = "jsonTopicName")
    public void consumeMessage(String message) {
        System.err.println("Consuming message : " + message);
    }

}

package main.pc;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @KafkaListener(topics = "topicName", groupId = "groupId")
    public void consumeMessage(String message) {
        System.err.println("Consuming message : " + message);
    }

}

package main.consumer;

import lombok.extern.java.Log;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Log
@Component
public class JsonConsumer {

    @KafkaListener(topics = "jsonTopicName")
    public void consumeMessage(String message) {
        log.info("Consuming json message : " + message);
    }

}

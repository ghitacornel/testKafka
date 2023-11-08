package main.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StringConsumer {

    @KafkaListener(topics = "stringTopicName")
    public void consumeMessage(String message) {
        log.info("Consuming string message : " + message);
    }

}

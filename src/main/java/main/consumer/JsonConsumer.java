package main.consumer;

import lombok.extern.java.Log;
import main.model.DataModel;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Log
@Component
public class JsonConsumer {

    @KafkaListener(topics = "jsonTopicName", containerFactory = "kafkaListenerDataModelContainerFactory")
    public void consumeMessage(DataModel message) {
        log.info("Consuming json message : " + message);
    }

}

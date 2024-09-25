package main.consumer;

import lombok.extern.slf4j.Slf4j;
import main.model.DataModel;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JsonConsumer {

    @KafkaListener(topics = "jsonTopicName", containerFactory = "kafkaListenerDataModelContainerFactory")
    public void consumeMessage(DataModel message) {
        log.info("Consuming json message : " + message);
    }

}

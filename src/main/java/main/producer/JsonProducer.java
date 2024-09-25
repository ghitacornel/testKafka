package main.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import main.model.DataModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class JsonProducer {

    @Value(value = "${kafka.jsonTopicName}")
    private String topicName;

    private final KafkaTemplate<String, DataModel> kafkaTemplate;

    public void sendMessage(DataModel message) {
        log.info("producing message : {}", message);
        kafkaTemplate.send(topicName, message);
    }

}

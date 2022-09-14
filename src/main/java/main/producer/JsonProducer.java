package main.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JsonProducer {

    @Value(value = "${kafka.jsonTopicName}")
    private String topicName;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        System.out.println("producing message : " + message);
        kafkaTemplate.send(topicName, message);
    }

}

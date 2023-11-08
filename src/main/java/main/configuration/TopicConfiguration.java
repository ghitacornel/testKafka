package main.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class TopicConfiguration {

    @Value(value = "${kafka.stringTopicName}")
    private String stringTopicName;

    @Value(value = "${kafka.jsonTopicName}")
    private String jsonTopicName;

    @Bean
    NewTopic stringTopic() {
        return new NewTopic(stringTopicName, 1, (short) 1);
    }

    @Bean
    NewTopic jsonTopic() {
        return new NewTopic(jsonTopicName, 1, (short) 1);
    }
}
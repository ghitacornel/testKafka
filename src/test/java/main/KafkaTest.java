package main;

import main.consumer.JsonConsumer;
import main.consumer.StringConsumer;
import main.model.DataModel;
import main.producer.JsonProducer;
import main.producer.StringProducer;
import main.simulator.JsonExchangeSimulator;
import main.simulator.StringExchangeSimulator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@EmbeddedKafka(
        ports = {29092},
        partitions = 1,
        topics = {"stringTopicName", "jsonTopicName"}
)
@SpringBootTest
public class KafkaTest {

    // do not generate data while testing
    @MockitoBean
    private JsonExchangeSimulator jsonExchangeSimulator;

    // do not generate data while testing
    @MockitoBean
    private StringExchangeSimulator stringExchangeSimulator;

    @Autowired
    JsonProducer jsonProducer;

    @Autowired
    StringProducer stringProducer;

    @Autowired
    JsonConsumer jsonConsumer;

    @Autowired
    StringConsumer stringConsumer;

    @Test
    public void test() {

        // ensure startup time
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Assertions.assertNull(jsonConsumer.lastDataModel);
        Assertions.assertNull(stringConsumer.lastMessage);
        jsonProducer.sendMessage(new DataModel());
        stringProducer.sendMessage("test message");

        // ensure consuming time
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Assertions.assertNotNull(jsonConsumer.lastDataModel);
        Assertions.assertNotNull(stringConsumer.lastMessage);
        Assertions.assertEquals("test message", stringConsumer.lastMessage);
    }

}

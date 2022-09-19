package main;

import main.producer.JsonProducer;
import main.producer.StringProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootTest
public class StringProducerStringConsumerTest {

    @Autowired
    StringProducer stringProducer;

    @Autowired
    JsonProducer jsonProducer;

    @Test
    public void testProducerConsumer() {

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        AtomicInteger counter;
        counter = new AtomicInteger();
        while (true) {
            int value = counter.getAndIncrement();
            if (value > 100) break;
            stringProducer.sendMessage("string message " + value);
        }

        counter = new AtomicInteger();
        while (true) {
            int value = counter.getAndIncrement();
            if (value > 100) break;
            jsonProducer.sendMessage("json message " + value);
        }

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}

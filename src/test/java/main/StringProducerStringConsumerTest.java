package main;

import main.producer.StringProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StringProducerStringConsumerTest {

    @Autowired
    StringProducer producer;

    @Test
    public void testProducerConsumer() {

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        AtomicInteger counter = new AtomicInteger();
        while (true) {
            int value = counter.getAndIncrement();
            if (value > 1000) break;
            producer.sendMessage("message " + value);
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

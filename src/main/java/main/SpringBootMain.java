package main;

import main.producer.Producer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
public class SpringBootMain {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootMain.class, args);

        // play like in PRODUCTION
        Producer producer = context.getBean(Producer.class);
        AtomicInteger counter = new AtomicInteger();
        while (true) {
            int value = counter.getAndIncrement();
            if (value > 1000) break;
            producer.sendMessage("message " + value);
        }
        // and wait for the effect
    }
}

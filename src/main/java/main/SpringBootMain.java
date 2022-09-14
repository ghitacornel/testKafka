package main;

import lombok.RequiredArgsConstructor;
import main.producer.StringProducer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@SpringBootApplication
public class SpringBootMain {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMain.class, args);
    }

    @Configuration
    @EnableScheduling
    public static class SchedulerConfiguration {
    }

    @Component
    @RequiredArgsConstructor
    public static class Timer {
        private final StringProducer producer;

        @Scheduled(fixedRate = 1000)
        public void reportCurrentTime() {
            producer.sendMessage("message " + new Date());
        }
    }


}

package main.timers;

import lombok.RequiredArgsConstructor;
import main.producer.JsonProducer;
import main.producer.StringProducer;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@Configuration
@RequiredArgsConstructor
public class Timer {
    private final StringProducer stringProducer;
    private final JsonProducer jsonProducer;

    @Scheduled(fixedRate = 1000)
    public void stringProducer() {
        stringProducer.sendMessage("string message " + new Date());
    }

    @Scheduled(fixedRate = 1000)
    public void jsonProducer() {
        jsonProducer.sendMessage("json message " + new Date());
    }
}

package main.simulator;

import lombok.RequiredArgsConstructor;
import main.producer.JsonProducer;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class JsonExchangeSimulator {

    private final JsonProducer producer;

    private int count = -1;

    @Scheduled(fixedRate = 1000)
    public void sendMessage() {
        producer.sendMessage("json message sent " + (count--) + " " + new Date());
    }
}

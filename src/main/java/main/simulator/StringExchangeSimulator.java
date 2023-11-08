package main.simulator;

import lombok.RequiredArgsConstructor;
import main.producer.StringProducer;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class StringExchangeSimulator {

    private final StringProducer producer;

    private int count = 1;

    @Scheduled(fixedRate = 1000)
    public void sendMessage() {
        producer.sendMessage("string message sent " + (count++) + " " + new Date());
    }
}

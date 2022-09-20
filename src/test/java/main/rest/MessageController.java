package main.rest;

import lombok.RequiredArgsConstructor;
import main.producer.JsonProducer;
import main.producer.StringProducer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MessageController {

    private final StringProducer stringProducer;
    private final JsonProducer jsonProducer;

    @GetMapping("string")
    public void sendString() {
        stringProducer.sendMessage("rest string message sent");
    }

    @GetMapping("json")
    public void sendJson() {
        stringProducer.sendMessage("rest json message sent");
    }

}

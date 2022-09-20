package main.timers;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@SpringBootTest
public class TestViaTimers {

    @Test
    @SneakyThrows
    public void testProducerConsumer() {
        TimeUnit.SECONDS.sleep(10);
        // observe produce consume
    }
}

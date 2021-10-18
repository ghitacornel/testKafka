package main;

import main.pc.Producer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootMain {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootMain.class, args);
        Producer producer = context.getBean(Producer.class);
        for (int i = 0; i < 100; i++)
            producer.sendMessage("message " + i);
    }
}

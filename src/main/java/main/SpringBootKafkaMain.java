package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SpringBootKafkaMain {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootKafkaMain.class, args);
    }

}

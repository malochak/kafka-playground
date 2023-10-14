package dev.mkon.kafkaplayground;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaPlaygroundApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaPlaygroundApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate) {
        return args -> {
            for (int i = 0; i < 100_000; i++) {
                kafkaTemplate.send("example-topic", "%d Hello Hello KAFKA!".formatted(i));
            }
        };
    }
}

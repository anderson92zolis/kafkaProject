package com.amigoscode;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.Random;

@SpringBootApplication
public class KafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate) {
		return args -> {
			for (int i = 0; i < 10; i++) {
				kafkaTemplate.send("amigoscode", "hello kafka :"+i);
			}
			// kafkaTemplate.send("amigoscode","hello Kafka");
		};
	}
}
	//        .\zookeeper-server-start.bat C:/Software/kafka/config/zookeeper.properties

	//        kafka-server-start.bat C:/Software/kafka/config/server.properties


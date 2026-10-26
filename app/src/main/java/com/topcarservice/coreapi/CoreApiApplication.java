package com.topcarservice.coreapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@EnableFeignClients
@SpringBootApplication
public class CoreApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreApiApplication.class, args);
	}

}

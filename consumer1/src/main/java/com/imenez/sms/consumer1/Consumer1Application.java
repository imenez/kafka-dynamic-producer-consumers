package com.imenez.sms.consumer1;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Consumer1Application {

	public static void main(String[] args) {
		SpringApplication.run(Consumer1Application.class, args);
	}

	@Bean
	public ObjectMapper getObjectMapper(){
		return new ObjectMapper();
	}

}

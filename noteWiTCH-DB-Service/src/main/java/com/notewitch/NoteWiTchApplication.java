package com.notewitch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class NoteWiTchApplication {

	public static void main(String[] args) {
		SpringApplication.run(NoteWiTchApplication.class, args);
	}
}

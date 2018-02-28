package com.notewitch.witch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class NoteWiTchEurekaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NoteWiTchEurekaServiceApplication.class, args);
	}
}

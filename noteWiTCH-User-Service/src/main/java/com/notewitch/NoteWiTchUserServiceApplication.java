package com.notewitch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

import com.notewitch.DTO.MapProperties;


@EnableDiscoveryClient
@SpringBootApplication
@EnableConfigurationProperties(value = MapProperties.class)
public class NoteWiTchUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NoteWiTchUserServiceApplication.class, args);
	}
	
    @LoadBalanced
    @Bean
    RestTemplate loadBalanced() {
        return new RestTemplate();
    }

    @Primary
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

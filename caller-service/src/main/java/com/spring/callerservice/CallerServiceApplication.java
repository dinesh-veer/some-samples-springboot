package com.spring.callerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CallerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CallerServiceApplication.class, args);
	}

}

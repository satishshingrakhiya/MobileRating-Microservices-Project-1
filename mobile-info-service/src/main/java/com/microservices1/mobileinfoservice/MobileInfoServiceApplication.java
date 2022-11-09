package com.microservices1.mobileinfoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MobileInfoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobileInfoServiceApplication.class, args);
	}

}

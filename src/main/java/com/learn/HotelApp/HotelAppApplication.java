package com.learn.HotelApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class HotelAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelAppApplication.class, args);
	}

}

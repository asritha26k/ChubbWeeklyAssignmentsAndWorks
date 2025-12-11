package com.flight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.flight.service.FilesStorageService;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;

@SpringBootApplication
public class FlightBookingSystemApplication {

	@Resource
	FilesStorageService storageService;

	public static void main(String[] args) {
		SpringApplication.run(FlightBookingSystemApplication.class, args);
	}

	@PostConstruct
	public void init() {
		storageService.init();
	}
}

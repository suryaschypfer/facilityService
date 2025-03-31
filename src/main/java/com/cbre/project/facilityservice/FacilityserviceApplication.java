package com.cbre.project.facilityservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.cbre.project.facilityservice", "config"})
public class FacilityserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FacilityserviceApplication.class, args);
	}

}

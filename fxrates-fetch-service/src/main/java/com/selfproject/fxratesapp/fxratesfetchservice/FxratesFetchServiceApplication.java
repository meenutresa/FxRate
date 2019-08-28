package com.selfproject.fxratesapp.fxratesfetchservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableFeignClients
public class FxratesFetchServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FxratesFetchServiceApplication.class, args);
	}

}

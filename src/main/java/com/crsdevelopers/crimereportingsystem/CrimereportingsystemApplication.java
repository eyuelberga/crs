package com.crsdevelopers.crimereportingsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.crsdevelopers.crimereportingsystem.services.UserService;

@SpringBootApplication
public class CrimereportingsystemApplication {
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(CrimereportingsystemApplication.class, args);
	}

}


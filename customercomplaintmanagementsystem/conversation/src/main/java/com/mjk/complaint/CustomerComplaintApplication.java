package com.mjk.complaint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

public class CustomerComplaintApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerComplaintApplication.class, args);
	}

}

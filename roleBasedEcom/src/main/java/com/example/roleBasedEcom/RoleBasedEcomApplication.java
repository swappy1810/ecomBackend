package com.example.roleBasedEcom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class RoleBasedEcomApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoleBasedEcomApplication.class, args);
	}

}

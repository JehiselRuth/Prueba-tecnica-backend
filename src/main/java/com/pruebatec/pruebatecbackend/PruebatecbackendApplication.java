package com.pruebatec.pruebatecbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class PruebatecbackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebatecbackendApplication.class, args);
	}

}

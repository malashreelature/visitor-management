package com.diatoz.visitor.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class VisitorManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(VisitorManagementApplication.class, args);
	}


}

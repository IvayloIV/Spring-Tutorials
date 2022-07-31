package com.pluralsight.springbootjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAwareImpl")
public class ConferenceDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConferenceDemoApplication.class, args);
	}

}

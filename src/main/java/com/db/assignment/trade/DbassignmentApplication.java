package com.db.assignment.trade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DbassignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbassignmentApplication.class, args);
	}

}

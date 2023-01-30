package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com")
public class SpringBootMain {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMain.class, args);
	}

}

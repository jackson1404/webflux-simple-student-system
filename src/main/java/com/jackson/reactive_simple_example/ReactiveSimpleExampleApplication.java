package com.jackson.reactive_simple_example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
@EnableR2dbcRepositories(basePackages = "com.jackson.reactive_simple_example.repository")
public class ReactiveSimpleExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveSimpleExampleApplication.class, args);
	}

}

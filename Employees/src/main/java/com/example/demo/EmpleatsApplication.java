package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@ComponentScan({"com.example.demo"})
@EntityScan("com.example.demo")
@EnableJpaRepositories("com.example.demo")
@SpringBootApplication
public class EmpleatsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpleatsApplication.class, args);
	}

}

package com.diklatproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EntityScan("com.diklatproject.entity*")
@ComponentScan(basePackages = { "com.diklatproject.*" })
@EnableJpaRepositories("com.diklatproject.dao")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class DiklatprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiklatprojectApplication.class, args);
	}
}

package com.id.corpu.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class CorpuBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(CorpuBackendApplication.class, args);
	}
}

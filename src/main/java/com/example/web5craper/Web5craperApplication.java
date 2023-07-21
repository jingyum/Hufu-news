package com.example.web5craper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("generator.mapper")
@ComponentScan(basePackages = {"com.example", "generator"})
public class Web5craperApplication {
	public static void main(String[] args) {
		SpringApplication.run(Web5craperApplication.class, args);
	}
}

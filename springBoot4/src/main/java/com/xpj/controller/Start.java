package com.xpj.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication(scanBasePackages="com.xpj")
public class Start {

	public static void main(String[] args) {
		SpringApplication.run(Start.class, args);
	}
}

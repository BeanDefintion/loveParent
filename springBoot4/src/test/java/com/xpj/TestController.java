package com.xpj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com.xpj")
public class TestController {

	public static void main(String[] args) {
		SpringApplication.run(TestController.class, args);
	}
}

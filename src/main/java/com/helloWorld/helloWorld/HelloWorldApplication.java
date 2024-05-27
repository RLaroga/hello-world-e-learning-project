package com.helloWorld.helloWorld;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.helloWorld.helloWorld.mapper")
@SpringBootApplication(scanBasePackages = {"com.helloWorld", "com.helloWorld.helloWorld.mapper"})
public class HelloWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
		System.out.println("Run Successfully");
	}

}

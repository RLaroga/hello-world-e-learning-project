package com.helloWorld.helloWorld;

import com.helloWorld.helloWorld.entity.User;
import org.apache.ibatis.type.MappedTypes;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@MappedTypes(User.class)
@SpringBootApplication(scanBasePackages = {"com.helloWorld.helloWorld.mapper"})
public class HelloWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
		System.out.println("Run Successfully");
	}

}

package com.example.java_sr_29m;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class JavaSr29mApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaSr29mApplication.class, args);
	}

}

package com.pkpfoods.web.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class PkpFoodsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PkpFoodsApplication.class, args);
	}

}

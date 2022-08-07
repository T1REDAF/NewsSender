package com.github.t1redaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class NewsSenderApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsSenderApplication.class, args);
	}

}

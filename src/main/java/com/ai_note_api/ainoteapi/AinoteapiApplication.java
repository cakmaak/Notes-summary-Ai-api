package com.ai_note_api.ainoteapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;


@EnableRetry
@SpringBootApplication
public class AinoteapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AinoteapiApplication.class, args);
	}

}

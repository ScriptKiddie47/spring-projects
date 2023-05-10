package com.scripter.javajackson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaJacksonApplication implements CommandLineRunner{

	
	private static final Logger log = LoggerFactory.getLogger(JavaJacksonApplication.class);

	
	public static void main(String[] args) {
		SpringApplication.run(JavaJacksonApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		log.info("Hello There");
		
	}

}
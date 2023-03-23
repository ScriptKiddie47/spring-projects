package com.scriptkiddie.gsreactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.scriptkiddie.gsreactive.handler.GreetingClient;

@SpringBootApplication
public class GsReactiveApplication {

	public static void main(String[] args) {
//		SpringApplication.run(GsReactiveApplication.class, args);
		ConfigurableApplicationContext applicationContext = SpringApplication
				.run(GsReactiveApplication.class, args);
		
		GreetingClient client = applicationContext.getBean(GreetingClient.class);
		System.out.println(">>message = " + client.getMessage().block());
		
	}

}

package com.scriptkiddie.gsreactive.router;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.scriptkiddie.gsreactive.handler.GreetingHandler;

@Configuration(proxyBeanMethods = false)
public class GreetingRouter {
	
	@Bean
	public RouterFunction<ServerResponse> route(GreetingHandler gHandler){
		return RouterFunctions
				.route(GET("/hello")
						.and(accept(MediaType.APPLICATION_JSON)),gHandler::hello);
	}
}

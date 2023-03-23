package com.scriptkiddie.gsreactive.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.scriptkiddie.gsreactive.model.Greeting;

import reactor.core.publisher.Mono;

@Component
public class GreetingHandler {
	
		
	public Mono<ServerResponse> hello(ServerRequest request){
		return ServerResponse
				.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromValue(new Greeting("Hello , Spring!")));
	}
	
}

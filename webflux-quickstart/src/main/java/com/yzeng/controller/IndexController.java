package com.yzeng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.yzeng.handler.TimeHandler;

import reactor.core.publisher.Mono;

@RestController
public class IndexController {

	@Autowired
	private TimeHandler timeHandler;
	
	@GetMapping("/ok/{id}")
	public Mono<String> hello(@PathVariable("id")Integer id){
		return Mono.just("success"+id);
	}
	
	/*@GetMapping("/time")
	public Mono<ServerResponse> getTime(ServerRequest request){
		return timeHandler.getCurrentTime(request);
	}
	
	@GetMapping("/date")
	public Mono<ServerResponse> getDate(ServerRequest request){
		return timeHandler.getCurrentDate(request);
	}*/
}

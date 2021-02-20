package com.nit.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ClientService {
	
	public void invokeMonoObject() {
		String url="http://localhost:9898/index";
		WebClient client=WebClient.create();
					client.get()
								.uri(url)
								.retrieve()
								.bodyToMono(String.class)
								.block();
	}
	public void invokeFluxObject() {
		String url="http://localhost:9898/getEvents";
		WebClient client=WebClient.create();
		client.get()
		.uri(url)
		.retrieve()
		.bodyToFlux(String.class)
		.subscribe(System.out::println);
	}
}

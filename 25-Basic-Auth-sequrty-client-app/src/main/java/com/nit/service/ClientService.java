package com.nit.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClientService {
	
	public String invokeWishApp() {
		String url="http://localhost:9898/wish";
		
		/*
		 //this is the first approach
		
		String authStr = "admin:admin@123";
		String base64Creds = Base64.getEncoder().encodeToString(authStr.getBytes());
		// create headers
		HttpHeaders headers = new HttpHeaders();
		// headers.setBasicAuth("admin", "admin@123");
		headers.add("Authorization", "Basic " + base64Creds);
		// create request
		 */	   
		
		//create the object of HttpHeader
		HttpHeaders header=new HttpHeaders();
		header.setBasicAuth("admin", "admin@123");
		HttpEntity request = new HttpEntity(header);

		//create the object of restRemplate
		RestTemplate template=new RestTemplate();
		ResponseEntity<String> entity = template.exchange(url, HttpMethod.GET, request, String.class);
		String responce = entity.getBody();
		return responce;
	}
	
}

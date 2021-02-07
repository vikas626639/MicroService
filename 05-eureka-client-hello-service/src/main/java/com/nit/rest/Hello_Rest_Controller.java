package com.nit.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello_Rest_Controller {
	
	@GetMapping("/hello/{name}")
	public String get_Hello(@PathVariable("name")String name) {
		return "hello "+name;
	}	
	
}

package com.nit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageRestController {
	@GetMapping("/index/{name}")
	public String greetMsg(@PathVariable("name")String name) {
		return "Hiiii "+name;
	}
	
}

package com.nit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeRestController {
	
	@GetMapping("/welcome")
	public String Welcome() {
		return "Welcome to Spring Boot Rest Controller";
	}
	
}

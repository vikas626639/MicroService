package com.nit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthbasicSecurityRestController {
	@GetMapping("/wish")
	public String wishMsg() {
		return "Welcome To springboot ....";
	}
}

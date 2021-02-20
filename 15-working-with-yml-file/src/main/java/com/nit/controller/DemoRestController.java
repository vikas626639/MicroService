package com.nit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nit.confige.DemoConfigProp;
import com.nit.constants.AppConstants;

@RestController
public class DemoRestController {
	
	@Autowired
	private DemoConfigProp prop;
	
	@GetMapping("/greet")
	public String getGreetMsg() {
		return prop.getProperties().get(AppConstants.greetMsg);
	}
	
	//insted of hardcoding the value in restController 
	//better to read value from yml file
	
	//reading the second properties from the yml file
	
	@GetMapping("/welcome")
	public String welcomeMsg() {
		return prop.getProperties().get(AppConstants.welcomeMsg);
	}

}

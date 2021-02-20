package com.nit.rest;

import org.omg.CORBA.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class CircuitRestController {
	@GetMapping("/getmsg")
	@HystrixCommand(fallbackMethod = "doprocess")
	public String getMsg() {
		int i=4/0;
		return "hiiiiii vikas";
	}
	
	public String doprocess() {
		return "from dopress-->hiiiiii vikas";
	}
}

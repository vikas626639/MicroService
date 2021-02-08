package com.nit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nit.Fiegn.Hello_service;

@RestController
public class hi_Rest_Controller {
	
	@Autowired
	private Hello_service helloservice;  //calling hello service class create object here and get responce
	
	@GetMapping("/gethi/{name}")
	public String get_hi_msg(@PathVariable("name")String name) {
		String msg="hi ";
		String hellomsg = helloservice.get_Hellomsg(name);
		return msg+"---"+hellomsg;
	}
}

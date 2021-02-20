package com.nit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZipkinRestController {
	
	
	//create the logger object
	Logger logger=LoggerFactory.getLogger(ZipkinRestController.class);
	
		@GetMapping("/welcome")
		public String welcomeMsg() {
			logger.info("**********get-welcomeMsg()-execution start");
			String msg="hello vikas yadav";
			logger.info("**********get-welcomeMsg()-execution ended");
			return msg;
		}
}

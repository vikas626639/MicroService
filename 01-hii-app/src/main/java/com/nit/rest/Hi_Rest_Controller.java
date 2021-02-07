package com.nit.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hi_Rest_Controller {
	
	@GetMapping("/hi")
		public String  getHi() {
			return "hi vikas";
		}
}

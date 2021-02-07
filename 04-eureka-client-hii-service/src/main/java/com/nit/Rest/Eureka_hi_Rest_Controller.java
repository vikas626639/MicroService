package com.nit.Rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Eureka_hi_Rest_Controller {

	@GetMapping("/hi/{name}")
		public String get_hi(@PathVariable("name")String name) {
			return "hiiiii "+name;
		}
}

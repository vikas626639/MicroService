package com.nit.Fiegn;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HELLO-SERVICE")
public interface Hello_service {
	
	@GetMapping("/hello/{name}")
	public String get_Hellomsg(@PathVariable("name") String name);
}

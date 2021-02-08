package com.nit;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:1111",name = "stock-price-service")
//@FeignClient(value = "http://localhost:1111")
public interface GetStockPrice {
	
	@GetMapping("/stockprice/{companyName}")
	public ResponseEntity<Double> getStockPrice(@PathVariable("companyName") String companyName);
}

package com.nit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nit.GetStockPrice;

@RestController
public class StockCalcRestController {

	//get feign client interface
	@Autowired
	private GetStockPrice stockprice;
	
	
	@GetMapping(value="/calc/{name}/{qty}")
	public ResponseEntity<String> totalStockPrice(@PathVariable("name")String name,@PathVariable("qty")Integer qty) {
		//use fiegn
//		String responce="hiiiiii";
		ResponseEntity<Double> price = stockprice.getStockPrice(name);
		
		int statuscode = price.getStatusCode().value();
		Double totalprice=null;
		if(statuscode==200) {
			Double comstocpric = price.getBody();
			totalprice=comstocpric*qty;
		}
		
		String responce="Total Price="+totalprice;
		return new ResponseEntity<>(responce,HttpStatus.OK);
	}
	
}

package com.nit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nit.service.Stockprice_interface;

@RestController
public class StockRestController {
	@Autowired
	private Stockprice_interface service;
	
	
	@GetMapping(value="/stockprice/{companyName}")
	public ResponseEntity<Double> getStockprice(@PathVariable("companyName")String name){
		//use service
		Double stockprice = service.getStockprice(name);
		return new ResponseEntity<>(stockprice,HttpStatus.OK);
	}
}

package com.nit.RestController;

import java.util.ArrayList;
import java.util.List;

//import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.nit.Service.Customer;
import com.nit.Service.CustomerService;

public class CustomerRestController {
	
	@Autowired
	private CustomerService service;
	/**
	 * This method is used to Customer records in post request
	 * @param customers
	 * @return
	 */
	
	/*
	 * @PostMapping(value = "/addCustomer", consumes = { MediaType.APPLICATION_JSON,
	 * MediaType.APPLICATION_XML } )
	 */
	
	@GetMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Customer>getAll(){
		Customer c1=new Customer(101, "vikas", "vikas@");
		Customer c2=new Customer(102, "Raj", "Raj@");
		Customer c3=new Customer(103, "John", "Prabha@s");
		List<Customer>list=new ArrayList();
		list.add(c1);
		list.add(c2);
		list.add(c3);
		return list;
		
	}
	
	
	@PostMapping(value = "/addCustomer", 
			consumes = { 
					MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE
			}
	)
	public String addCustomer(@RequestBody List<Customer> customers) {
		return service.add(customers);
	}
}

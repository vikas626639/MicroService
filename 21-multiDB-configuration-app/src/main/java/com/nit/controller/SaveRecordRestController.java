package com.nit.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nit.service.SaveBookObject;
import com.nit.service.SaveUserobject;

@RestController
public class SaveRecordRestController {
	
	@Autowired
	private SaveBookObject service;
	
	@Autowired
	private SaveUserobject service1;
	
	@GetMapping("/index")
	public String getResult() {
		//use services
		Serializable saveBookRecord = service.saveBookRecord();
		Serializable saveUserRecord = service1.saveUserRecord();
		return "Record saved";
	}
}

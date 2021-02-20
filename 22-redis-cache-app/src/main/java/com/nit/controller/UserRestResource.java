package com.nit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nit.entity.User;
import com.nit.repo.UserRepoImpl;
@RestController
public class UserRestResource {
	
	@Autowired
	private UserRepoImpl repo;
	
	@PostMapping(value = "/add", consumes = "application/json")
	public User add(@RequestBody User user) {
		repo.save(user);
		return repo.findById(user.getId());	
	}
	
}

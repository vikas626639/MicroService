package com.nit.repo;

import java.util.Map;

import com.nit.entity.User;

public interface UserRepo {
	void save(User user);
	Map<String, User>finaAll();
	User findById(Integer id);
	void update(User user);
	void delete(String id);
}

package com.nit.repo;

import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.nit.entity.User;
@Repository
public class UserRepoImpl implements UserRepo {
	
	private HashOperations ho;
	//inject the RedisTemplate 
	public UserRepoImpl(RedisTemplate rst) {
		this.ho=rst.opsForHash();
	}
	
	@Override
	public void save(User user) {
		ho.put("user", user.getId(), user);
	}

	@Override
	public Map<String, User> finaAll() {
		return ho.entries("user");
	}

	@Override
	public User findById(Integer integer) {
		
		User user=(User) ho.get("user", integer);
		if(user==null) {
			//load from data base logic
		}
		return user;
	}

	@Override
	public void update(User user) {
		save(user);
	}

	@Override
	public void delete(String id) {
		ho.delete("user", id);
	}

}

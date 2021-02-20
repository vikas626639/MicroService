package com.nit.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.user.entity.UserEntity1;
import com.nit.user.repo.UserRepo;

@Service
public class SaveUserImpl implements SaveUserobject {
	
	@Autowired
	private UserRepo repo;
	//Stream.of(,new UserEntity(102, "prabha")).collect(Collectors.toList())
	@Override
	public Serializable saveUserRecord() {
		//create the object of Entity class
		UserEntity1 entity=null,entity1=null;
		List<UserEntity1> listEntity =null;
		try {
			entity=new UserEntity1(101, "vikas");
			entity1=new UserEntity1(101, "prabha");
			listEntity = repo.saveAll(List.of(entity, entity1));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (Serializable) listEntity;
	}

}

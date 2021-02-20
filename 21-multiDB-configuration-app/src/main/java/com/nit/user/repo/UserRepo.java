package com.nit.user.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.user.entity.UserEntity1;

public interface UserRepo extends JpaRepository<UserEntity1, Serializable> {

}

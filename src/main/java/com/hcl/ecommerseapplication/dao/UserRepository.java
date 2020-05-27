package com.hcl.ecommerseapplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.ecommerseapplication.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	public User findByEmail(String email);

}

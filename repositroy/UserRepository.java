package com.ecommerceapplication.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ecommerceapplication.model.User;
public interface UserRepository extends JpaRepository<User, Integer>{
	public User findByEmailAndPassword(String email, String password);

}

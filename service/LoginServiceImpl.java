package com.ecommerceapplication.service;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecommerceapplication.dto.UserDto;
import com.ecommerceapplication.exception.UserNotFoundException;
import com.ecommerceapplication.model.User;
import com.ecommerceapplication.repositroy.UserRepository;
@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
	UserRepository loginRepository;
	private User user = new User();
	@Override
	public User login( @Valid UserDto userDto) {
		
		BeanUtils.copyProperties(userDto, user);

		User login = loginRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
		if (login == null) {
			throw new UserNotFoundException("email and password should not be empty");
		}
		if (!login.getPassword().equals(user.getPassword())) {
			throw new UserNotFoundException("password incorrect");
		}
		return login;
	}
	}



package com.ecommerceapplication.service;
import com.ecommerceapplication.dto.UserDto;
import com.ecommerceapplication.model.User;

public interface LoginService {
 public User login(UserDto userDto);
}

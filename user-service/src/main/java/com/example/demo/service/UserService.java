package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.model.UserEntity;
import com.example.demo.ui.UserResponseModel;

public interface UserService {
	
	public UserResponseModel createUser(UserDto userDto);
	
	public Iterable<UserResponseModel> getAllUsers();
	public UserEntity findByUserId(String userid);

}

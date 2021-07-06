package com.example.demo.controller;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.UUID;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.UserEntity;
import com.example.demo.service.UserService;
import com.example.demo.ui.UserRequestModel;
import com.example.demo.ui.UserResponseModel;

@RestController
@RequestMapping("/api/v1")
public class UserController {
	private ModelMapper modelMapper;
	private UserService userService;
	
	@Autowired
	public UserController(ModelMapper modelMapper, UserService userService) {
		this.modelMapper = modelMapper;
		this.userService = userService;
	}
	
	@PostMapping("/users")
	public ResponseEntity<UserResponseModel> createUser(@RequestBody UserRequestModel userDetails)
	{
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDto userDto=modelMapper.map(userDetails, UserDto.class);
		userDto.setUserId(UUID.randomUUID().toString());
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userDto));
	}
	@GetMapping("/users")
	public ResponseEntity<Iterable<UserResponseModel>> getAllUsers()
	{
		return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<UserResponseModel> displayUserByUserId(@PathVariable("userId") String userId)
	{
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity entity= userService.findByUserId(userId);
		if(entity==null)
		{
			throw new UserNotFoundException("user with giuven id not found");
		}
		UserResponseModel model=modelMapper.map(entity, UserResponseModel.class);
		return new ResponseEntity<UserResponseModel>(model,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/users/{userId}")
	public ResponseEntity<UserResponseModel> deleteUserByUserId(@PathVariable("userId") String userId)
	{
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return ResponseEntity.ok(modelMapper.map(userService.deleteByUserId(userId),UserResponseModel.class));
	}

}

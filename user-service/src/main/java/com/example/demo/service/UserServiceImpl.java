package com.example.demo.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserRepository;
import com.example.demo.dto.UserDto;
import com.example.demo.model.UserEntity;
import com.example.demo.ui.UserResponseModel;

@Service
public class UserServiceImpl implements UserService {

	private ModelMapper modelMapper;
	private UserRepository userRepository;

	@Autowired
	public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository) {
		
		this.modelMapper = modelMapper;
		this.userRepository = userRepository;
	}

	@Override
	public UserResponseModel createUser(UserDto userDto) {
		
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity userEntity=modelMapper.map(userDto, UserEntity.class);
		UserEntity userEntity2=userRepository.save(userEntity);
		
		return modelMapper.map(userEntity2, UserResponseModel.class);
	}

	@Override
	public Iterable<UserResponseModel> getAllUsers() {
		
		return null;
	}

}

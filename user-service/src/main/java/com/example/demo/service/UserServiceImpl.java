package com.example.demo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Iterable<UserEntity> uIterable=userRepository.findAll();
		Iterator<UserEntity> i=uIterable.iterator();
		List<UserResponseModel> list=new ArrayList<UserResponseModel>();
		while(i.hasNext())
		{
			list.add(modelMapper.map(i.next(), UserResponseModel.class));
		}
		return list;
	}

	@Override
	public UserEntity findByUserId(String userid) {
	
		
		return userRepository.findByUserId(userid);
	}

}

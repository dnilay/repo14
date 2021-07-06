package com.example.demo;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.dao.UserRepository;
import com.example.demo.model.UserEntity;

@SpringBootApplication
public class UserServiceApplication implements CommandLineRunner {

	private UserRepository userRepository;
	
	
	public UserServiceApplication(UserRepository userRepository) {
		
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {
		userRepository.save(new UserEntity(UUID.randomUUID().toString(), "John", "Doe", "john@email.com", "1234"));
		userRepository.save(new UserEntity(UUID.randomUUID().toString(), "Marry", "Public", "marry@email.com", "1234"));
		userRepository.save(new UserEntity(UUID.randomUUID().toString(), "Thomas", "Doe", "thomas@email.com", "1234"));
		userRepository.save(new UserEntity(UUID.randomUUID().toString(), "Marry", "Gold", "marryg@email.com", "1234"));
		
	}
}

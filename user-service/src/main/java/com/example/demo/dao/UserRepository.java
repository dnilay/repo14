package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserEntity;
@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {
	
	@Query
	public UserEntity findByUserId(String userid);
	@Query
	public List<UserEntity> findByFirstName(String firstName);

	public List<UserEntity> findByFirstNameAndLastName(String firstName,String lastName);
}

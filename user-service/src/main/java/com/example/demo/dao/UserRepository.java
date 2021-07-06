package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserEntity;
@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {

}

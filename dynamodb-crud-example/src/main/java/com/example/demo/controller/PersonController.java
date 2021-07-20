package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Person;
import com.example.demo.repository.PersonRepository;
@RestController
public class PersonController {
	
	private PersonRepository personRepository;

	@Autowired
	public PersonController(PersonRepository personRepository) {
		this.personRepository = personRepository;
	};
	
	@PostMapping("/persons")
	public ResponseEntity<Person> createPerson(@RequestBody Person person)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(personRepository.addPerson(person));
	}
	
	@GetMapping("/persons/{personId}")
	public ResponseEntity<Person> displayPersonByPersonId(@PathVariable("personId") String personId)
	{
		return ResponseEntity.ok(personRepository.findPersonByPersonId(personId));
	}
	
	

}

package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Beer;
import com.example.demo.service.BeerService;
@RestController
public class BeerController {
	
	private BeerService beerService;

	@Autowired
	public BeerController(BeerService beerService) {
		this.beerService = beerService;
	}
	
	@PostMapping("/api/beers")
	public ResponseEntity<Beer> createBeer(@RequestBody Beer beer)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(beerService.createBeer(beer));
	}
	
	@GetMapping("/api/beers")
	public ResponseEntity<List<Beer>> displayAllBeer()
	{
		return ResponseEntity.status(HttpStatus.OK).body(beerService.displayAllBeer());
	}
	
	@GetMapping("/api/beers/{beerName}")
	public ResponseEntity<List<Beer>> getBeerByName(@PathVariable("beerName") String beerName)
	{
		return ResponseEntity.status(HttpStatus.OK).body(beerService.getBeerByName(beerName));
	}

}

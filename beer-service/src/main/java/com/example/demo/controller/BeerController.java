package com.example.demo.controller;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BeerDto;
import com.example.demo.model.Beer;
import com.example.demo.service.BeerService;
import com.example.demo.ui.BeerRequestModel;
import com.example.demo.ui.BeerResponseModel;
@RestController
public class BeerController {
	
	private BeerService beerService;
	
	@Autowired
	public BeerController(BeerService beerService) {
		super();
		this.beerService = beerService;
	
	}

	@PostMapping("/api/beers")
	public ResponseEntity<BeerResponseModel> createBeer(@RequestBody BeerRequestModel beerDetails)
	{
		
		return ResponseEntity.status(HttpStatus.CREATED).body(beerService.createBeer(beerDetails));
	}
	
	@GetMapping("/api/beers")
	public ResponseEntity<List<BeerResponseModel>> displayAllBeer()
	{
		return ResponseEntity.status(HttpStatus.OK).body(beerService.displayAllBeer());
	}
	
	@GetMapping("/api/beers/{beerName}")
	public ResponseEntity<List<BeerResponseModel>> getBeerByName(@PathVariable("beerName") String beerName)
	{
		return ResponseEntity.status(HttpStatus.OK).body(beerService.getBeerByName(beerName));
	}

}

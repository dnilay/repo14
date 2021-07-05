package com.example.demo.repo;

import java.util.List;

import com.example.demo.model.Beer;

public interface BeerRepository {
	
	public Beer createBeer(Beer beer);
	public List<Beer> displayAllBeer();
	public List<Beer> getBeerByName(String beerName);
	

}

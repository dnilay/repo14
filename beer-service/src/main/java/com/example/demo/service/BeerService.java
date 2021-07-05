package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Beer;

public interface BeerService {
	public Beer createBeer(Beer beer);
	public List<Beer> displayAllBeer();
	public List<Beer> getBeerByName(String beerName);

}

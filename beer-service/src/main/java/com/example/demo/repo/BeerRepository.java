package com.example.demo.repo;

import java.util.List;

import com.example.demo.model.Beer;
import com.example.demo.ui.BeerResponseModel;

public interface BeerRepository {
	
	public Beer createBeer(Beer beer);
	public List<BeerResponseModel> displayAllBeer();
	public List<Beer> getBeerByName(String beerName);
	

}

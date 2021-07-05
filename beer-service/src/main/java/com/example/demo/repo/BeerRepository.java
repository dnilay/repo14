package com.example.demo.repo;

import java.util.List;

import com.example.demo.dto.BeerDto;
import com.example.demo.ui.BeerResponseModel;

public interface BeerRepository {
	
	public BeerResponseModel createBeer(BeerDto beer);
	public List<BeerResponseModel> displayAllBeer();
	public List<BeerResponseModel> getBeerByName(String beerName);
	

}

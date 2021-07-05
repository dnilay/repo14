package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.BeerDto;
import com.example.demo.model.Beer;
import com.example.demo.ui.BeerRequestModel;
import com.example.demo.ui.BeerResponseModel;

public interface BeerService {
	public BeerResponseModel createBeer(BeerRequestModel beerRequestModel);
	public List<BeerResponseModel> displayAllBeer();
	public List<BeerResponseModel> getBeerByName(String beerName);

}

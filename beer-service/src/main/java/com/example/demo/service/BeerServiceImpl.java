package com.example.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Beer;
import com.example.demo.repo.BeerRepository;
import com.example.demo.ui.BeerResponseModel;

@Service
public class BeerServiceImpl implements BeerService {

	private BeerRepository beerRepository;

	@Autowired
	public BeerServiceImpl(BeerRepository beerRepository) {
		

		this.beerRepository = beerRepository;
		
	}

	@Override
	public Beer createBeer(Beer beer) {
		// TODO Auto-generated method stub
		return beerRepository.createBeer(beer);
	}

	@Override
	public List<BeerResponseModel> displayAllBeer() {
		// TODO Auto-generated method stub
		return beerRepository.displayAllBeer();
	}

	@Override
	public List<Beer> getBeerByName(String beerName) {
		// TODO Auto-generated method stub
		return beerRepository.getBeerByName(beerName);
	}

}

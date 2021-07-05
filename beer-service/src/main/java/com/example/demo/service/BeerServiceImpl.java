package com.example.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Beer;
import com.example.demo.repo.BeerRepository;

@Service
public class BeerServiceImpl implements BeerService {

	private BeerRepository beerRepository;

	@Autowired
	public BeerServiceImpl(BeerRepository beerRepository) {
		

		this.beerRepository = beerRepository;
		/*
		 * beerRepository.createBeer(new Beer(1, UUID.randomUUID().toString(), "Beer-1",
		 * 200.0, true));
		 * 
		 * beerRepository.createBeer(new Beer(2, UUID.randomUUID().toString(), "Beer-2",
		 * 201.0, true)); beerRepository.createBeer(new Beer(3,
		 * UUID.randomUUID().toString(), "Beer-3", 202.0, false));
		 * beerRepository.createBeer(new Beer(4, UUID.randomUUID().toString(), "Beer-4",
		 * 203.0, false)); beerRepository.createBeer(new Beer(5,
		 * UUID.randomUUID().toString(), "Beer-5", 204.0, true));
		 * beerRepository.createBeer(new Beer(6, UUID.randomUUID().toString(), "Beer-1",
		 * 206.0, false));
		 */
	}

	@Override
	public Beer createBeer(Beer beer) {
		// TODO Auto-generated method stub
		return beerRepository.createBeer(beer);
	}

	@Override
	public List<Beer> displayAllBeer() {
		// TODO Auto-generated method stub
		return beerRepository.displayAllBeer();
	}

	@Override
	public List<Beer> getBeerByName(String beerName) {
		// TODO Auto-generated method stub
		return beerRepository.getBeerByName(beerName);
	}

}

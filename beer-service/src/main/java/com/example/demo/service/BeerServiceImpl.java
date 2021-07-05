package com.example.demo.service;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BeerDto;
import com.example.demo.model.Beer;
import com.example.demo.repo.BeerRepository;
import com.example.demo.ui.BeerRequestModel;
import com.example.demo.ui.BeerResponseModel;

@Service
public class BeerServiceImpl implements BeerService {

	private BeerRepository beerRepository;
	private ModelMapper modelMapper;

	

	public BeerServiceImpl(BeerRepository beerRepository, ModelMapper modelMapper) {
		super();
		this.beerRepository = beerRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public BeerResponseModel createBeer(BeerRequestModel beerRequestModel) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		BeerDto dto=modelMapper.map(beerRequestModel, BeerDto.class);
		dto.setBeerId(UUID.randomUUID().toString());
		return beerRepository.createBeer(dto);
	}

	@Override
	public List<BeerResponseModel> displayAllBeer() {
		// TODO Auto-generated method stub
		return beerRepository.displayAllBeer();
	}

	@Override
	public List<BeerResponseModel> getBeerByName(String beerName) {
		// TODO Auto-generated method stub
		return beerRepository.getBeerByName(beerName);
	}

}

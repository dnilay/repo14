package com.example.demo.repo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.demo.model.Beer;
import com.example.demo.ui.BeerResponseModel;

@Repository
@EnableTransactionManagement
public class BeerRepositoryImpl implements BeerRepository {
	
	private EntityManager entityManager;
	private ModelMapper modelMapper;
	

@Autowired
	public BeerRepositoryImpl(EntityManager entityManager, ModelMapper modelMapper) {
		this.entityManager = entityManager;
		this.modelMapper = modelMapper;
	}

	@Override
	@Transactional
	public Beer createBeer(Beer beer) {
		// TODO Auto-generated method stub
	
		beer.setBeerId(UUID.randomUUID().toString());
		entityManager.persist(beer);
		return beer;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<BeerResponseModel> displayAllBeer() {
		// TODO Auto-generated method stub
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Query query=entityManager.createQuery("SELECT B from Beer B",Beer.class);
		List<Beer> beers=query.getResultList();
		List<BeerResponseModel> beerResponseModelsList=new ArrayList<BeerResponseModel>();
		Iterator<Beer> i=beers.iterator();
		while(i.hasNext())
		{
			beerResponseModelsList.add(modelMapper.map(i.next(), BeerResponseModel.class));
		}
		return beerResponseModelsList;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Beer> getBeerByName(String beerName) {
		// TODO Auto-generated method stub

		Query query=entityManager.createQuery("SELECT B.beerId,B.beerName,B.beerPrice,B.isAvailable from Beer B where B.beerName=:bName",Beer.class).setParameter("bName", beerName);
		
		return query.getResultList();
	}

}

package com.example.demo.repo;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.demo.model.Beer;

@Repository
@EnableTransactionManagement
public class BeerRepositoryImpl implements BeerRepository {
	
	private EntityManager entityManager;
	
	@Autowired
	public BeerRepositoryImpl(EntityManager entityManager) {
		
		this.entityManager = entityManager;
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
	public List<Beer> displayAllBeer() {
		// TODO Auto-generated method stub
		Query query=entityManager.createQuery("SELECT B FROM Beer B",Beer.class);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Beer> getBeerByName(String beerName) {
		// TODO Auto-generated method stub

		Query query=entityManager.createQuery("SELECT B from Beer B where B.beerName=:bName",Beer.class).setParameter("bName", beerName);
		return query.getResultList();
	}

}

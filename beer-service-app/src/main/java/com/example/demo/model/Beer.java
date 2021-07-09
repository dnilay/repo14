package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Beer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "beer_id")
	private Integer id;
	@Column(name = "beer_name", nullable = false)
	private String beerName;
	@Column(name = "beer_price")
	private Double beerPrice;
	@Column(name = "beer_availability")
	private Boolean isAvailable;
	public Beer(String beerName, Double beerPrice, Boolean isAvailable) {
		super();
		this.beerName = beerName;
		this.beerPrice = beerPrice;
		this.isAvailable = isAvailable;
	}
	
	

}

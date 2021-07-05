package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Beer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "beer_id", nullable = false, unique = true)
	private String beerId;
	@Column(name = "beer_name", nullable = false)
	private String beerName;
	@Column(name = "beer_price", nullable = false)
	private Double beerPrice;
	@Column(name = "available")
	private Boolean isAvailable;

}

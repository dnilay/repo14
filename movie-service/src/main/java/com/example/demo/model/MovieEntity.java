package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "movie_id")
	private Integer movieId;
	@Column(name = "movie_name", nullable = false, unique = true)
	private String movieName;
	@Enumerated(value = EnumType.STRING)
	@Column(name = "movie_genre")
	private Genre genre;
	@JsonProperty
	private Boolean isReleased;
	public MovieEntity(String movieName, Genre genre, Boolean isReleased) {
		super();
		this.movieName = movieName;
		this.genre = genre;
		this.isReleased = isReleased;
	}

}

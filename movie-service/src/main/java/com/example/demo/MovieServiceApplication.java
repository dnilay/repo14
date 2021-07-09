package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.example.demo.dao.MovieDAO;
import com.example.demo.model.Genre;
import com.example.demo.model.MovieEntity;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
@EnableEurekaClient
public class MovieServiceApplication implements CommandLineRunner {
	private MovieDAO movieDAO;

	@Autowired
	public MovieServiceApplication(MovieDAO movieDAO) {
		this.movieDAO = movieDAO;
	}

	public static void main(String[] args) {
		SpringApplication.run(MovieServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("performing bootstraping data...");
		movieDAO.save(new MovieEntity("Movie-1", Genre.ACTION, true));
		movieDAO.save(new MovieEntity("Movie-2", Genre.ROMATNTIC, false));
		movieDAO.save(new MovieEntity("Movie-3", Genre.BIOGRAPHY, true));
		movieDAO.save(new MovieEntity("Movie-4", Genre.THRILLER, true));
		movieDAO.save(new MovieEntity("Movie-5", Genre.HOROR, false));

		log.info("bootstraping done sucessfully...");
	}

}

package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.model.Movie;
import com.cognizant.repository.MovieRepository;

@RestController
@RequestMapping("/movielist")
public class MovieController {
@Autowired
private MovieRepository movieRepo;
@GetMapping("/details")
public List<Movie> getMovieListCustomer(){
	return movieRepo.findAll();
}
@GetMapping("/{id}")
public Movie getMovieById(@PathVariable("id") Long id) {
	return movieRepo.findById(id);
}
@PutMapping("/{id}")
public Movie updateMovie(@PathVariable("id") Long id,Movie movie) {
	movie.setId(id);
	return movieRepo.save(movie);
}

}

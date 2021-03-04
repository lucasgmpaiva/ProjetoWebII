package com.projeto.web.control;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.projeto.web.model.Movie;
import com.projeto.web.model.TVSeries;

@RestController
public class IndexController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	private String apiRoot = "https://api.themoviedb.org/3/";
	private String apiKey = "api_key=94bf8f41c148b47ddb8476bf39089b7d";
	
	/*
	 * @RequestMapping("/") public String index() { return "index.html"; }
	 */
	
	@GetMapping("/movie/popular")
	public List<Movie> getPopularMovies() {
		Movie[] popularMovies = restTemplate.getForObject(apiRoot + "movie/popular" + "?" +  apiKey, Movie[].class);
		return Arrays.asList(popularMovies);
	}
	
	@GetMapping("/series/popular")
	public List<TVSeries> getPopularSeries() {
		TVSeries[] popularSeries = restTemplate.getForObject(apiRoot + "movie/popular" + "?" +  apiKey, TVSeries[].class);
		return Arrays.asList(popularSeries);
	}
	
	@GetMapping("/movie/{id}")
	public Movie getMovieById(@PathVariable(value = "id") Long id) {
		Movie movie = restTemplate.getForObject(apiRoot + "movie/" + id + "?" +  apiKey, Movie.class);
		return movie;
	}
	
	@GetMapping("/series/{id}")
	public TVSeries getSerieById(@PathVariable(value = "id") Long id) {
		TVSeries tVSeries = restTemplate.getForObject(apiRoot + "tv/" + id + "?" +  apiKey, TVSeries.class);
		return tVSeries;
	}

}

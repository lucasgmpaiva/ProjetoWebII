package com.projeto.web.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.projeto.web.model.Movie;
import com.projeto.web.model.MovieSet;
import com.projeto.web.model.TVSeries;
import com.projeto.web.model.TVSeriesSet;

public class ConsumeAPI {
	
	@Autowired
	private RestTemplate restTemplate;
	
	private String apiRoot = "https://api.themoviedb.org/3/";
	private String apiKey = "api_key=94bf8f41c148b47ddb8476bf39089b7d";
	
	public ConsumeAPI() {
		this.restTemplate = new RestTemplate();
	}
	
	// Movies' endpoints
	
	public Movie findMovieById(Long id) {
		return restTemplate.getForObject(apiRoot + "movie/" + id + "?" +  apiKey, Movie.class);
	}
	
	public MovieSet findMostPopularMovies() {
		return restTemplate.getForObject(apiRoot + "movie/popular" + "?" +  apiKey, MovieSet.class);
	}
	
	public MovieSet findTopRatedMovies() {
		return restTemplate.getForObject(apiRoot + "movie/top_rated" + "?" +  apiKey, MovieSet.class);
	}
	
	public MovieSet findMovieBySearch(String query) {
		return restTemplate.getForObject(apiRoot + "search/movie?" + apiKey + "&query=" + query, MovieSet.class);
	}
	
	// TVSeries' endpoints
	
	public TVSeries findSeriesById(Long id) {
		return restTemplate.getForObject(apiRoot + "tv/" + id + "?" +  apiKey, TVSeries.class);
	}
	
	public TVSeriesSet findMostPopularSeries() {
		return restTemplate.getForObject(apiRoot + "tv/popular" + "?" +  apiKey, TVSeriesSet.class);
	}
	
	public TVSeriesSet findTopRatedSeries() {
		return restTemplate.getForObject(apiRoot + "tv/top_rated" + "?" +  apiKey, TVSeriesSet.class);
	}
	
	public TVSeriesSet findSeriesBySearch(String query) {
		return restTemplate.getForObject(apiRoot + "search/tv?" + apiKey + "&query=" + query, TVSeriesSet.class);
	}

}

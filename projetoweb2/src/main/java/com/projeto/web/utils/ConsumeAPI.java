package com.projeto.web.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.projeto.web.model.Movie;

public class ConsumeAPI {
	
	@Autowired
	private RestTemplate restTemplate;
	
	private String apiRoot = "http://localhost:8081";
	
	public ConsumeAPI() {
		this.restTemplate = new RestTemplate();
	}
	
	public Movie findMovieById(Long id) {
		return restTemplate.getForObject(apiRoot + "/movie/" + id, Movie.class);
	}
	
	public Movie[] findAll() {
		return restTemplate.getForObject(apiRoot + "/movie/all", Movie[].class);
	}
	
	public Movie[] findMovieBySearch(String title, String director, String gender) {
		
		List<String> query = new ArrayList<String>();
		
		String filterTitle = "title=";
		String filterDirector = "director=";
		String filterGender = "gender=";
		
		if(title.equals("")) {
			filterTitle = "";
		} else {
			filterTitle+=title;
			query.add(filterTitle);
		}
		
		if(director.equals("")) {
			filterDirector = "";
		} else {
			filterDirector+=director;
			query.add(filterDirector);
		}
		
		if(gender.equals("")) {
			filterGender = "";
		} else {
			filterGender+=gender;
			query.add(filterGender);
		}
		
		String finalQuery = "";
		
		for(int i = 0; i<query.size(); i++) {
			if(i == 0)
				finalQuery+=query.get(i);
			else {
				finalQuery+="&";
				finalQuery+=query.get(i);
			}
		}
		
		return restTemplate.getForObject(apiRoot +
				"/movie/search?" +
				finalQuery,
				Movie[].class);
	}

}

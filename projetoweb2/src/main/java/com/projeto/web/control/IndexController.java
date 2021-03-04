package com.projeto.web.control;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projeto.web.model.Movie;
import com.projeto.web.model.MovieSet;
import com.projeto.web.model.TVSeries;
import com.projeto.web.model.TVSeriesSet;
import com.projeto.web.utils.ConsumeAPI;

@Controller
public class IndexController {
	
	private ConsumeAPI consumeAPI = new ConsumeAPI();
	
	Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@RequestMapping("/")
	public String index() {
		return "index"; 
	}
	 
	
	@GetMapping("/movie/popular")
	public String getPopularMovies() {
		MovieSet popularMovies = consumeAPI.findMostPopularMovies();
		logger.info(Arrays.asList(popularMovies.getResults()).toString());
		return "index";
	}
	
	  @GetMapping("/series/popular")
	  public String getPopularSeries() {
		  TVSeriesSet popularSeries = consumeAPI.findMostPopularSeries();
		  logger.info(Arrays.asList(popularSeries.getResults()).toString());
		  return "index";
	  }
	  
	  @GetMapping("/movie/top")
	  public String getTopRatedMovies() {
		  MovieSet topRatedMovies = consumeAPI.findTopRatedMovies();
		  logger.info(Arrays.asList(topRatedMovies.getResults()).toString());
		  return "index";
	  }
	  
	  @GetMapping("/series/top")
	  public String getTopRatedSeries() {
		  TVSeriesSet topRatedSeries = consumeAPI.findTopRatedSeries();
		  logger.info(Arrays.asList(topRatedSeries.getResults()).toString());
		  return "index";
	  }
	  
	  @GetMapping("/movie/{id}")
	  public String getMovieById(@PathVariable(value = "id") Long id) {
		  Movie movie = consumeAPI.findMovieById(id);
		  logger.info(movie.toString());
		  return "index";
	  }
	  
	  @GetMapping("/tv/{id}")
	  public String getSeriesById(@PathVariable(value = "id") Long id) {
		  TVSeries tvSeries = consumeAPI.findSeriesById(id);
		  logger.info(tvSeries.toString());
		  return "index";
	  }
	 

}

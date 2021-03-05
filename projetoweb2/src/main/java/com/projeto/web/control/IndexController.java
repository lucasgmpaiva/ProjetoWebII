package com.projeto.web.control;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String getPopularMovies(Model model) {
		MovieSet popularMovies = consumeAPI.findMostPopularMovies();
		model.addAttribute("movies", popularMovies.getResults());
		logger.info(Arrays.asList(popularMovies.getResults()).toString());
		return "list_movies";
	}
	
	  @GetMapping("/series/popular")
	  public String getPopularSeries(Model model) {
		  TVSeriesSet popularSeries = consumeAPI.findMostPopularSeries();
		  model.addAttribute("tvseries", popularSeries.getResults());
		  logger.info(Arrays.asList(popularSeries.getResults()).toString());
		  return "list_series";
	  }
	  
	  @GetMapping("/movie/top")
	  public String getTopRatedMovies(Model model) {
		  MovieSet topRatedMovies = consumeAPI.findTopRatedMovies();
		  model.addAttribute("movies", topRatedMovies.getResults());
		  logger.info(Arrays.asList(topRatedMovies.getResults()).toString());
		  return "list_movies";
	  }
	  
	  @GetMapping("/series/top")
	  public String getTopRatedSeries(Model model) {
		  TVSeriesSet topRatedSeries = consumeAPI.findTopRatedSeries();
		  model.addAttribute("tvseries", topRatedSeries.getResults());
		  logger.info(Arrays.asList(topRatedSeries.getResults()).toString());
		  return "list_series";
	  }
	  
	  @GetMapping("/movie/{id}")
	  public String getMovieById(@PathVariable(value = "id") Long id, Model model) {
		  Movie movie = consumeAPI.findMovieById(id);
		  List<Movie> movieArray = new ArrayList<Movie>();
		  movieArray.add(movie);
		  model.addAttribute("movies", movieArray);
		  logger.info(movie.toString());
		  return "list_movies";
	  }
	  
	  @GetMapping("/movie/search/{query}")
	  public String getMovieBySearch(@PathVariable(value = "query") String query, Model model) {
		  MovieSet movies = consumeAPI.findMovieBySearch(query);
		  model.addAttribute("movies", movies.getResults());
		  logger.info(Arrays.asList(movies.getResults()).toString());
		  return "list_movies";
	  }
	  
	  @GetMapping("/series/{id}")
	  public String getSeriesById(@PathVariable(value = "id") Long id, Model model) {
		  TVSeries tvSeries = consumeAPI.findSeriesById(id);
		  List<TVSeries> tvSeriesArray = new ArrayList<TVSeries>();
		  tvSeriesArray.add(tvSeries);
		  model.addAttribute("tvseries", tvSeriesArray);
		  logger.info(tvSeries.toString());
		  return "list_series";
	  }
	  
	  @GetMapping("/series/search/{query}")
	  public String getSeriesBySearch(@PathVariable(value = "query") String query, Model model) {
		  TVSeriesSet series = consumeAPI.findSeriesBySearch(query);
		  model.addAttribute("tvseries", series.getResults());
		  logger.info(Arrays.asList(series.getResults()).toString());
		  return "list_series";
	  }
	 

}

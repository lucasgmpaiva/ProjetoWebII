package com.projeto.web.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.projeto.web.model.Movie;
import com.projeto.web.utils.ConsumeAPI;

@Controller
public class IndexController {
	
	private ConsumeAPI consumeAPI = new ConsumeAPI();
	
	@RequestMapping("/")
	public String index() {
		return "index"; 
	}
	
	 @GetMapping("/movie/all")
	  public String getAllMovies(Model model) {
		  Movie[] movieArray = consumeAPI.findAll();
		  model.addAttribute("movies", movieArray);
		  return "list_movies";
	  }
	   
	 @RequestMapping(value="/movie/id", method=RequestMethod.POST)
	  public String getMovieById(@Param("id") String id, Model model) {
		  Movie movie = consumeAPI.findMovieById(Long.parseLong(id));
		  List<Movie> movieArray = new ArrayList<Movie>();
		  movieArray.add(movie);
		  model.addAttribute("movies", movieArray);
		  return "list_movies";
	  }
	  
	  @RequestMapping(value="/movie/search", method=RequestMethod.POST)
	  public String getMovieBySearch(Model model,
			  							@Param("title") String title,
			  							@Param("director") String director,
			  							@Param("gender") String gender) {
		 Movie[] movies = consumeAPI.findMovieBySearch(title, director, gender);
		 model.addAttribute("movies", movies);
		 return "list_movies";
	  }
	  
}

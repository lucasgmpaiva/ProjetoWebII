package com.projeto.web.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	   
	  @GetMapping("/movie/{id}")
	  public String getMovieById(@PathVariable(value = "id") Long id, Model model) {
		  Movie movie = consumeAPI.findMovieById(id);
		  List<Movie> movieArray = new ArrayList<Movie>();
		  movieArray.add(movie);
		  model.addAttribute("movies", movieArray);
		  return "list_movies";
	  }
	  
	  @RequestMapping(value="/movie/search", method=RequestMethod.POST)
	  public String getMovieBySearch(@ModelAttribute Movie movie, BindingResult bindingResult, Model model) {
		 
		 if(bindingResult.hasErrors()) {
			 return null;
		 }
		  
		 model.addAttribute("movie", movie);
		 Movie[] movies = consumeAPI.findMovieBySearch(movie.getTitle(), movie.getDirector(), movie.getGender());
		 model.addAttribute("movies", movies);
		 return "list_movies";
	  }
	  
}

package com.projeto.web.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieSet {
	
	private Integer total_results;
	private Movie[] results;
	
	public Integer getTotal_results() {
		return total_results;
	}
	public void setTotal_results(Integer total_results) {
		this.total_results = total_results;
	}
	public Movie[] getResults() {
		return results;
	}
	public void setResults(Movie[] results) {
		this.results = results;
	}

}

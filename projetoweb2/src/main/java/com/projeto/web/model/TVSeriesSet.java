package com.projeto.web.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TVSeriesSet {
	
	private Integer total_results;
	private TVSeries[] results;
	
	public Integer getTotal_results() {
		return total_results;
	}
	public void setTotal_results(Integer total_results) {
		this.total_results = total_results;
	}
	public TVSeries[] getResults() {
		return results;
	}
	public void setResults(TVSeries[] results) {
		this.results = results;
	}
	
	

}

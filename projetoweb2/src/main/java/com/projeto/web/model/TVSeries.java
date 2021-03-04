package com.projeto.web.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TVSeries {
	
	private int id;
	private String original_name;
	private Integer number_of_seasons;
	private String first_air_date;
	private String overview;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOriginal_name() {
		return original_name;
	}
	public void setOriginal_name(String original_name) {
		this.original_name = original_name;
	}
	public Integer getNumber_of_seasons() {
		return number_of_seasons;
	}
	public void setNumber_of_seasons(Integer number_of_seasons) {
		this.number_of_seasons = number_of_seasons;
	}
	public String getFirst_air_date() {
		return first_air_date;
	}
	public void setFirst_air_date(String first_air_date) {
		this.first_air_date = first_air_date;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	
	@Override
	public String toString() {
		return "TV Series {" + "Name = "
							+ original_name + " / "
							+ "First Air Date: "
							+ first_air_date + " / "
							+ "Overview = "
							+ overview + " / " +
							"Number of Seasons"
							+ number_of_seasons + "}";
	}
	
}

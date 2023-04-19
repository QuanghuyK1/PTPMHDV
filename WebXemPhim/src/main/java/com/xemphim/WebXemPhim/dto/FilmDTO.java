package com.xemphim.WebXemPhim.dto;

import java.util.Collection;
import java.util.Date;

public class FilmDTO {
	
	private String filmName;
	
	private String filmPosterPath;
	
	private String trailerPath;
	
	private String filmDescription;
	
	private Integer filmDuration;
	
	private Date releaseTime;
	
	private Integer oddFilm;
	
	private Collection<String> categories;
	
	private String nation;
	
	public String getFilmName() {
		return filmName;
	}
	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}
	public String getFilmPosterPath() {
		return filmPosterPath;
	}
	public void setFilmPosterPath(String filmPosterPath) {
		this.filmPosterPath = filmPosterPath;
	}
	public String getTrailerPath() {
		return trailerPath;
	}
	public void setTrailerPath(String trailerPath) {
		this.trailerPath = trailerPath;
	}
	public String getFilmDescription() {
		return filmDescription;
	}
	public void setFilmDescription(String filmDescription) {
		this.filmDescription = filmDescription;
	}
	public Integer getFilmDuration() {
		return filmDuration;
	}
	public void setFilmDuration(Integer filmDuration) {
		this.filmDuration = filmDuration;
	}
	public Date getReleaseTime() {
		return releaseTime;
	}
	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}
	public Integer isOddFilm() {
		return oddFilm;
	}
	public void setOddFilm(Integer oddFilm) {
		this.oddFilm = oddFilm;
	}
	public Collection<String> getCategories() {
		return categories;
	}
	public void setCategories(Collection<String> categories) {
		this.categories = categories;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public Integer getOddFilm() {
		return oddFilm;
	}
}
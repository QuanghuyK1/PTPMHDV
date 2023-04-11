package com.xemphim.WebXemPhim.converter;

import org.springframework.stereotype.Component;

import com.xemphim.WebXemPhim.dto.FilmDTO;
import com.xemphim.WebXemPhim.models.Film;

@Component
public class FilmConverter {
	
	public FilmDTO toDTO(Film film) {
		FilmDTO dto = new FilmDTO();
		if(film.getFilmName() != null) {
			dto.setFilmName(film.getFilmName());
			dto.setFilmPosterPath(film.getFilmPosterPath());
			dto.setTrailerPath(film.getTrailerPath());
			dto.setFilmPath(film.getFilmPath());
		}
		return dto;
	}
}

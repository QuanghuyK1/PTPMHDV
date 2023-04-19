package com.xemphim.WebXemPhim.converter;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xemphim.WebXemPhim.dto.FilmDTO;
import com.xemphim.WebXemPhim.models.Film;
import com.xemphim.WebXemPhim.models.FilmCategory;
import com.xemphim.WebXemPhim.repositories.FilmCategoryRepository;

@Component
public class FilmConverter {
	
	@Autowired
	FilmCategoryRepository filmCategoryRepository;
	
	public FilmDTO toDTO(Film film) {
		FilmDTO dto = new FilmDTO();
		if(film.getFilmName() != null) {
			dto.setFilmName(film.getFilmName());
			dto.setFilmPosterPath(film.getFilmPosterPath());
			dto.setTrailerPath(film.getTrailerPath());
			dto.setFilmDescription(film.getFilmDescription());
			dto.setFilmDuration(film.getFilmDuration());
			dto.setReleaseTime(film.getReleaseTime());
			dto.setOddFilm(film.getOddFilm());
			dto.setNation(film.getNation().getNationName());
			Collection<FilmCategory> filmCategories = filmCategoryRepository.findByFilmName(film.getFilmName());
			Collection<String> categories = new ArrayList<String>();
			for (FilmCategory item: filmCategories)
				categories.add(item.getId().getCategory().getCategoryName());
			dto.setCategories(categories);
		}
		return dto;
	}
}

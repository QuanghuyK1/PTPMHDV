package com.xemphim.WebXemPhim.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xemphim.WebXemPhim.converter.FilmConverter;
import com.xemphim.WebXemPhim.dto.FilmDTO;
import com.xemphim.WebXemPhim.models.Category;
import com.xemphim.WebXemPhim.models.Film;
import com.xemphim.WebXemPhim.repositories.FilmCategoryRepository;
import com.xemphim.WebXemPhim.repositories.FilmRepository;
import com.xemphim.WebXemPhim.service.FilmService;

@Service
public class FilmServiceImpl implements FilmService{

	@Autowired
	private FilmRepository filmRepository;
	
	@Autowired
	private FilmConverter filmConverter;
	
	@Autowired
	private FilmCategoryRepository filmCategoryRepository;

	@Override
	public Film findOneByFilmName(String filmName) {
		Film film = new Film();
		film = filmRepository.findOneByFilmName(filmName);
		return film;
	}

	@Override
	public Collection<FilmDTO> findFilmDTOByFilmName(String filmName) {
		if(!(filmName == null || filmName.equals(""))) {
			Collection<FilmDTO> filmDTOs = new ArrayList<>();
			Collection<Film> films = new ArrayList<>();
			Collection<Category> categories = new ArrayList<>();
			Film film = new Film();
			film = filmRepository.findOneByFilmName(filmName);
			categories = filmCategoryRepository.findCategoryByFilm(film);
			for (Category category: categories) {
				Collection<Film> filmCollection = new ArrayList<>();
				filmCollection = filmCategoryRepository.findFilmByCategory(category, film);
				films.addAll(filmCollection);
			}
			if (films.size() > 0) {
				FilmDTO dto = new FilmDTO();
				for (Film item: films) {
					dto = filmConverter.toDTO(item);
					filmDTOs.add(dto);
				}
				return filmDTOs;
			}			
		}
		return null;
	}
}

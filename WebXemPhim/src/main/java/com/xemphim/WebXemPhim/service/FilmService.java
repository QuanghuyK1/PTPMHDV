package com.xemphim.WebXemPhim.service;

import java.util.Collection;

import com.xemphim.WebXemPhim.dto.FilmDTO;
import com.xemphim.WebXemPhim.models.Film;

public interface FilmService {
	Film findOneByFilmName(String filmName);
	Collection<FilmDTO> findFilmDTOByFilmName(String filmName);
}

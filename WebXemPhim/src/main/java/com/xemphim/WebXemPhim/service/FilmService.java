package com.xemphim.WebXemPhim.service;

import com.xemphim.WebXemPhim.dto.FilmDTO;

public interface FilmService {
	FilmDTO findByFilmName(String filmName);
}

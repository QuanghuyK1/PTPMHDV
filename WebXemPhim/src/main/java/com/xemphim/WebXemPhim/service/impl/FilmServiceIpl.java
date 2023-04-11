package com.xemphim.WebXemPhim.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xemphim.WebXemPhim.converter.FilmConverter;
import com.xemphim.WebXemPhim.dto.FilmDTO;
import com.xemphim.WebXemPhim.repositories.FilmRepository;
import com.xemphim.WebXemPhim.service.FilmService;

@Service
public class FilmServiceIpl implements FilmService{

	@Autowired
	private FilmRepository filmRepository;
	
	@Autowired
	private FilmConverter filmConverter;

	@Override
	public FilmDTO findByFilmName(String filmName) {
		FilmDTO filmDTO = new FilmDTO();
		filmDTO = filmConverter.toDTO(filmRepository.findByFilmName(filmName));
		return filmDTO;
	}	
}

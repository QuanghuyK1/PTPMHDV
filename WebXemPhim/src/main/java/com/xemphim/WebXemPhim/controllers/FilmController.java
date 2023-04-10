package com.xemphim.WebXemPhim.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xemphim.WebXemPhim.dto.FilmDTO;
import com.xemphim.WebXemPhim.service.FilmService;

@CrossOrigin
@RestController
@RequestMapping(path = "/film")
public class FilmController {

	@Autowired
	FilmService filmService;
	
	@GetMapping
	public FilmDTO film(@RequestBody String filmName) {
		FilmDTO filmDTO = new FilmDTO();
		filmDTO = filmService.findByFilmName(filmName);
		return filmDTO;
	}
}

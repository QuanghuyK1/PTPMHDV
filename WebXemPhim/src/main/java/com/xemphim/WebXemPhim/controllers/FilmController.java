package com.xemphim.WebXemPhim.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xemphim.WebXemPhim.controllers.output.Detail1;
import com.xemphim.WebXemPhim.converter.FilmConverter;
import com.xemphim.WebXemPhim.service.CommentService;
import com.xemphim.WebXemPhim.service.FilmService;

@CrossOrigin
@RestController
@RequestMapping(path = "/home")
public class FilmController {

	@Autowired
	FilmService filmService;
	
	@Autowired
	CommentService commentService;
	
	@Autowired
	FilmConverter filmConverter;
	
	@GetMapping(value = "film/{filmName}")
	public Detail1 film(@PathVariable String filmName) {
		Detail1 detail1 = new Detail1();
		detail1.setFilmDTO(filmConverter.toDTO(filmService.findOneByFilmName(filmName)));
		detail1.setFilmDTOs(filmService.findFilmDTOByFilmName(filmName));
		detail1.setComments(commentService.findCommentDTOByFilmName(filmName));
		return detail1;
	}
}

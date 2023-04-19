package com.xemphim.WebXemPhim.controllers;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xemphim.WebXemPhim.dto.FilmPackageDTO;
import com.xemphim.WebXemPhim.service.FilmPackageService;

@CrossOrigin
@RestController
@RequestMapping(path = "/home")
public class FilmPackageController {

	@Autowired
	private FilmPackageService filmPackageService;
	
	@GetMapping(value = "filmpackage")
	public Collection<FilmPackageDTO> getInfo() {
		Collection<FilmPackageDTO> filmPackageDTOs = new ArrayList<FilmPackageDTO>();
		filmPackageDTOs = filmPackageService.findFilmPackageDTOByDate();
		return filmPackageDTOs;
	}
}

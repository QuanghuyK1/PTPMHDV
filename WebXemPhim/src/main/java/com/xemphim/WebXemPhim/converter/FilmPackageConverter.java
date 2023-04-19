package com.xemphim.WebXemPhim.converter;

import org.springframework.stereotype.Component;

import com.xemphim.WebXemPhim.dto.FilmPackageDTO;
import com.xemphim.WebXemPhim.models.FilmPackage;

@Component
public class FilmPackageConverter {
	
	public FilmPackageDTO toDTO(FilmPackage filmPackage) {
		FilmPackageDTO filmPackageDTO = new FilmPackageDTO();
		filmPackageDTO.setUsed_time(filmPackage.getUsedTime());
		filmPackageDTO.setPrice(filmPackage.getPrice());
		return filmPackageDTO;
	}
}

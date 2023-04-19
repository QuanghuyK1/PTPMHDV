package com.xemphim.WebXemPhim.service;

import java.util.Collection;

import com.xemphim.WebXemPhim.dto.FilmPackageDTO;

public interface FilmPackageService {
	Collection<FilmPackageDTO> findFilmPackageDTOByDate();
}

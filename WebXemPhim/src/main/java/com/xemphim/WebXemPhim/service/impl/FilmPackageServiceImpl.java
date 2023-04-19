package com.xemphim.WebXemPhim.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xemphim.WebXemPhim.converter.FilmPackageConverter;
import com.xemphim.WebXemPhim.dto.FilmPackageDTO;
import com.xemphim.WebXemPhim.repositories.FilmPackageRepository;
import com.xemphim.WebXemPhim.service.FilmPackageService;

@Service
public class FilmPackageServiceImpl implements FilmPackageService{

	@Autowired
	FilmPackageRepository filmPackageRepository;
	
	@Autowired
	FilmPackageConverter filmPackageConverter;
	
	@Override
	public Collection<FilmPackageDTO> findFilmPackageDTOByDate() {
		Collection<FilmPackageDTO> filmPackageDTOs = new ArrayList<FilmPackageDTO>();
		Collection<Object[]> objects = new ArrayList<Object[]>();
		objects = filmPackageRepository.getFilmPackages();		
		for (Object[] item: objects) {
			FilmPackageDTO dto = new FilmPackageDTO();
			dto.setUsed_time((Integer) item[0]);
			dto.setPrice((Integer) item[1]);
			filmPackageDTOs.add(dto);
		}
		return filmPackageDTOs;
	}	
}
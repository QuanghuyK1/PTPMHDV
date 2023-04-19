package com.xemphim.WebXemPhim.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xemphim.WebXemPhim.models.Film;

public interface FilmRepository extends JpaRepository<Film, Integer>{
	Film findOneByFilmName(String filmName);
}

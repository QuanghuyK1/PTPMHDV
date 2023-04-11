package com.xemphim.WebXemPhim.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.xemphim.WebXemPhim.models.Film;

public interface FilmRepository extends JpaRepository<Film, Integer>{
	@Query("SELECT f FROM Film f WHERE f.filmName=?1")
	Film findByFilmName(String filmName);
}

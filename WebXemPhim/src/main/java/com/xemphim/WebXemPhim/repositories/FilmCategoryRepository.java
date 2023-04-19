package com.xemphim.WebXemPhim.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.xemphim.WebXemPhim.models.Category;
import com.xemphim.WebXemPhim.models.Film;
import com.xemphim.WebXemPhim.models.FilmCategory;
import com.xemphim.WebXemPhim.models.FilmCategoryId;

@EnableJpaRepositories
public interface FilmCategoryRepository extends JpaRepository<FilmCategory, FilmCategoryId>{

	@Query("SELECT fc.id.category FROM FilmCategory fc WHERE fc.id.film = ?1")
	Collection<Category> findCategoryByFilm(Film film);
	
	@Query("SELECT fc.id.film FROM FilmCategory fc WHERE fc.id.category = ?1 and fc.id.film != ?2")
	Collection<Film> findFilmByCategory(Category category, Film film);
	
	@Query("SELECT fc FROM FilmCategory fc WHERE fc.id.film.filmName = ?1")
	Collection<FilmCategory> findByFilmName(String filmName);
}

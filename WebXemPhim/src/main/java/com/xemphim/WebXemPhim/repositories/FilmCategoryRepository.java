package com.xemphim.WebXemPhim.repositories;

import com.xemphim.WebXemPhim.models.Category;
import com.xemphim.WebXemPhim.models.Film;
import com.xemphim.WebXemPhim.models.FilmCategory;
import com.xemphim.WebXemPhim.models.FilmCategoryId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmCategoryRepository extends JpaRepository<FilmCategory, FilmCategoryId> {

    List<Film> findAllByIdCategory(Category category);

    List<FilmCategory> findAllByIdFilm(Film film);

}

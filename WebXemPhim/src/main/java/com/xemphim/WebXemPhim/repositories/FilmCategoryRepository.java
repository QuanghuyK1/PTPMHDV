package com.xemphim.WebXemPhim.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xemphim.WebXemPhim.models.FilmCategory;
import com.xemphim.WebXemPhim.models.FilmCategoryId;

public interface FilmCategoryRepository extends JpaRepository<FilmCategory, FilmCategoryId>{

}

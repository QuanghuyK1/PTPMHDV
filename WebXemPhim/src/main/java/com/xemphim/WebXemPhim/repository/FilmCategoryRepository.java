package com.xemphim.WebXemPhim.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xemphim.WebXemPhim.entity.FilmCategory;
import com.xemphim.WebXemPhim.entity.FilmCategoryId;

public interface FilmCategoryRepository extends JpaRepository<FilmCategory, FilmCategoryId>{

}

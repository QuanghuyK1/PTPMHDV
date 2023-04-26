package com.xemphim.WebXemPhim.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.xemphim.WebXemPhim.entity.FilmPackage;

public interface FilmPackageRepository extends JpaRepository<FilmPackage, Integer>{
	@Query(value = "CALL get_film_packages", nativeQuery = true)
	List<Object[]> getFilmPackages();
	
    FilmPackage findOneByfilmPackageId(String id);
}

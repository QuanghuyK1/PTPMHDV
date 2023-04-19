package com.xemphim.WebXemPhim.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.xemphim.WebXemPhim.models.FilmPackage;

@Repository
public interface FilmPackageRepository extends JpaRepository<FilmPackage, Integer>{
	@Query(value = "CALL GET_FILM_PACKAGES", nativeQuery = true)
	Collection<Object[]> getFilmPackages();
}

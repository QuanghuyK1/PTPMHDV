package com.xemphim.WebXemPhim.repositories;

import com.xemphim.WebXemPhim.models.FilmPackage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmPackageRepository extends JpaRepository<FilmPackage, Integer>{

    FilmPackage findOneByfilmPackageId(String id);
}

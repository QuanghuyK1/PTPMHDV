package com.xemphim.WebXemPhim.repository;

import com.xemphim.WebXemPhim.entity.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface FilmRepository extends JpaRepository<Film, Integer>{

    Film findOneByFilmNameIgnoreCaseAndStatusTrue(String filmName);
    ArrayList<Film> findByStatusOrderByReleaseTimeDesc(boolean status);

    Page<Film> findAllByFilmNameIgnoreCaseContainsAndStatusTrue(String filmName, Pageable pageable);

    Film findByFilmId(String filmId);
}

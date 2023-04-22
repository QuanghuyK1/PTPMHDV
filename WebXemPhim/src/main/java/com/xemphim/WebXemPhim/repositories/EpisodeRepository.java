package com.xemphim.WebXemPhim.repositories;

import com.xemphim.WebXemPhim.models.Episode;
import com.xemphim.WebXemPhim.models.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EpisodeRepository extends JpaRepository<Episode, Integer>{

    List<Episode> findByFilm(Film film);
}

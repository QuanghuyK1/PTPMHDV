package com.xemphim.WebXemPhim.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xemphim.WebXemPhim.models.FilmActor;
import com.xemphim.WebXemPhim.models.FilmActorId;

public interface FilmActorRepository extends JpaRepository<FilmActor, FilmActorId>{

}

package com.xemphim.WebXemPhim.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xemphim.WebXemPhim.entity.FilmActor;
import com.xemphim.WebXemPhim.entity.FilmActorId;

public interface FilmActorRepository extends JpaRepository<FilmActor, FilmActorId>{

}

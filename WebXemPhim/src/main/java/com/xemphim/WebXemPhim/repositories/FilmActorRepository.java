package com.xemphim.WebXemPhim.repositories;

import com.xemphim.WebXemPhim.models.FilmActor;
import com.xemphim.WebXemPhim.models.FilmActorId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmActorRepository extends JpaRepository<FilmActor, FilmActorId>{

}

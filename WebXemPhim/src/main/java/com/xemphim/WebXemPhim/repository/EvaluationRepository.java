package com.xemphim.WebXemPhim.repository;

import com.xemphim.WebXemPhim.entity.Account;
import com.xemphim.WebXemPhim.entity.Evaluation;
import com.xemphim.WebXemPhim.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface EvaluationRepository extends JpaRepository<Evaluation, Integer>{

    List<Evaluation> findByIdFilm(Film film);
}

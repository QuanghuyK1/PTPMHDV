package com.xemphim.WebXemPhim.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xemphim.WebXemPhim.models.Evaluation;
import com.xemphim.WebXemPhim.models.EvaluationId;

public interface EvaluationRepository extends JpaRepository<Evaluation, EvaluationId>{

}

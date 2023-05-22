package com.xemphim.WebXemPhim.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "evaluations")
public class Evaluation {

	@EmbeddedId
	private EvaluationId id;
	
	@Column(name = "star_number")
	private Float starNumber;
	
	private String comment;

	public EvaluationId getId() {
		return id;
	}

	public void setId(EvaluationId id) {
		this.id = id;
	}

	public Float getStarNumber() {
		return starNumber;
	}

	public void setStarNumber(Float starNumber) {
		this.starNumber = starNumber;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
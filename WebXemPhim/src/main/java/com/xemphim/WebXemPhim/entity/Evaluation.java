package com.xemphim.WebXemPhim.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "evaluations")
public class Evaluation {

	@EmbeddedId
	private EvaluationId id;
	
	@Column(name = "star_number")
	private Float starNumber;
	
	private String comment;

	@JsonFormat(pattern="yyyy-MM-dd HH-mm-ss",timezone="Asia/Ho_Chi_Minh")
	private Date eval_time;

	public EvaluationId getId() {
		return id;
	}

	public void setId(EvaluationId id) {
		this.id = id;
	}

	public Date getEval_time() {
		return eval_time;
	}

	public void setEval_time(Date eval_time) {
		this.eval_time = eval_time;
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
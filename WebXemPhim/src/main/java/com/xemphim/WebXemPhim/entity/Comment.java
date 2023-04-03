package com.xemphim.WebXemPhim.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "comments")
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "comment_id")
	private Integer commentId;
	
	@Column(name = "comment_content")
	private String commentContent;
	
	@Column(name = "comment_level")
	private Integer commentLevel;
	
	@Column(name = "comment_date")
	private Date commentDate;
	
	@ManyToOne
	@JoinColumn(name = "film_id")
	private Film film;
	
	@ManyToOne
	@JoinColumn(name = "account_name")
	private Account account;

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Integer getCommentLevel() {
		return commentLevel;
	}

	public void setCommentLevel(Integer commentLevel) {
		this.commentLevel = commentLevel;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}
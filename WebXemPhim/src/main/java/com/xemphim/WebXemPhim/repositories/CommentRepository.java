package com.xemphim.WebXemPhim.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.xemphim.WebXemPhim.models.Comment;
import com.xemphim.WebXemPhim.models.CommentId;
import com.xemphim.WebXemPhim.models.Film;

public interface CommentRepository extends JpaRepository<Comment, CommentId>{
	@Query("SELECT cm FROM Comment cm WHERE cm.id.film = ?1")
	Collection<Comment> findByFilm(Film film);
}

package com.xemphim.WebXemPhim.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xemphim.WebXemPhim.models.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer>{

}

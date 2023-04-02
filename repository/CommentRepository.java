package com.xemphim.WebXemPhim.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xemphim.WebXemPhim.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer>{

}

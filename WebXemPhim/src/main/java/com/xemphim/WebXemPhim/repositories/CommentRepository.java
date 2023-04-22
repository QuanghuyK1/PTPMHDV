package com.xemphim.WebXemPhim.repositories;

import com.xemphim.WebXemPhim.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer>{

}

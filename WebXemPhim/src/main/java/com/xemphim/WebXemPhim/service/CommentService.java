package com.xemphim.WebXemPhim.service;

import java.util.Collection;

import com.xemphim.WebXemPhim.dto.CommentDTO;

public interface CommentService {
	Collection<CommentDTO> findCommentDTOByFilmName(String filmName);
}

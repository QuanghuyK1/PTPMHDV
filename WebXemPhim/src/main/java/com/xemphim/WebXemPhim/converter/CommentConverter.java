package com.xemphim.WebXemPhim.converter;

import org.springframework.stereotype.Component;

import com.xemphim.WebXemPhim.dto.CommentDTO;
import com.xemphim.WebXemPhim.models.Comment;

@Component
public class CommentConverter {
	public CommentDTO toDTO(Comment comment) {
		CommentDTO dto = new CommentDTO();
		dto.setCommentContent(comment.getCommentContent());
		dto.setCommentDate(comment.getCommentDate());
		dto.setAccountName(comment.getId().getAccount().getAccountName());
		return dto;
	}
}

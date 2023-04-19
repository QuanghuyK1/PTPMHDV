package com.xemphim.WebXemPhim.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xemphim.WebXemPhim.converter.CommentConverter;
import com.xemphim.WebXemPhim.dto.CommentDTO;
import com.xemphim.WebXemPhim.models.Comment;
import com.xemphim.WebXemPhim.models.Film;
import com.xemphim.WebXemPhim.repositories.CommentRepository;
import com.xemphim.WebXemPhim.repositories.FilmRepository;
import com.xemphim.WebXemPhim.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private FilmRepository filmRepository;
	
	@Autowired
	private CommentConverter commentConverter;

	@Override
	public Collection<CommentDTO> findCommentDTOByFilmName(String filmName) {		
		Film film = new Film();
		film = filmRepository.findOneByFilmName(filmName);
		if (film != null) {
			Collection<CommentDTO> commentDTOs = new ArrayList<>();
			Collection<Comment> comments = new ArrayList<>();
			comments = commentRepository.findByFilm(film);
			for (Comment item: comments) {
				CommentDTO commentDTO = new CommentDTO();
				commentDTO = commentConverter.toDTO(item);
				commentDTOs.add(commentDTO);
			}
			return commentDTOs;
		}
		return null;
	}
}

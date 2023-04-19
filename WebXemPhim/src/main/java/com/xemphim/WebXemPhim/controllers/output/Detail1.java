package com.xemphim.WebXemPhim.controllers.output;

import java.util.Collection;

import com.xemphim.WebXemPhim.dto.CommentDTO;
import com.xemphim.WebXemPhim.dto.FilmDTO;

public class Detail1 {
	
	private FilmDTO filmDTO;
	
	private Collection<CommentDTO> comments;
	
	private Collection<FilmDTO> filmDTOs;

	public FilmDTO getFilmDTO() {
		return filmDTO;
	}

	public void setFilmDTO(FilmDTO filmDTO) {
		this.filmDTO = filmDTO;
	}

	public Collection<CommentDTO> getComments() {
		return comments;
	}

	public void setComments(Collection<CommentDTO> comments) {
		this.comments = comments;
	}

	public Collection<FilmDTO> getFilmDTOs() {
		return filmDTOs;
	}

	public void setFilmDTOs(Collection<FilmDTO> filmDTOs) {
		this.filmDTOs = filmDTOs;
	}
}

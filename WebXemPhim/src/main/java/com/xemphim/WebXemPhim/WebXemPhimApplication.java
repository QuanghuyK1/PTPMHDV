package com.xemphim.WebXemPhim;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import com.xemphim.WebXemPhim.converter.FilmConverter;
import com.xemphim.WebXemPhim.dto.FilmDTO;
import com.xemphim.WebXemPhim.repositories.FilmRepository;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class WebXemPhimApplication implements CommandLineRunner{
	
	@Autowired
	private FilmRepository filmRepository;
	
	@Autowired
	private FilmConverter filmConverter;
//	
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
	public static void main(String[] args) {
		SpringApplication.run(WebXemPhimApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		FilmDTO film = filmConverter.toDTO(filmRepository.findByFilmName("Mission: Impossible"));
		System.out.println(film.getFilmName());
	}
}

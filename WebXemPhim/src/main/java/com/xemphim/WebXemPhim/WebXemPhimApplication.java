package com.xemphim.WebXemPhim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class WebXemPhimApplication {//implements CommandLineRunner{
	
//	@Autowired
//	private FilmRepository filmRepository;
//	
//	@Autowired
//	private FilmConverter filmConverter;
//	
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
	public static void main(String[] args) {
		SpringApplication.run(WebXemPhimApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		FilmDTO film = filmConverter.toDTO(filmRepository.findOneByFilmName("Mission: Impossible"));
//		System.out.println(film.getFilmName());
//	}
}

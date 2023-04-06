package com.xemphim.WebXemPhim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class WebXemPhimApplication {//implements CommandLineRunner{
	
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
	public static void main(String[] args) {
		SpringApplication.run(WebXemPhimApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		String sql = "INSERT INTO accounts (account_name, password, user_id, role_id) VALUE (?, ?, ?, ?)";
//		int result = jdbcTemplate.update(sql, "nguyenvana", "12345678", 1, 1);
//		if(result > 0) System.out.println("A new row has been inserted.");
//	}
}

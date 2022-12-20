package com.ticktask.springboot.webapp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class WebappApplication {
	
	@Autowired
//	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(WebappApplication.class, args);
		
	}

//	@Override
//	public void run(String... args) throws Exception {
//		String sql = "INSERT INTO User (FName, LName, Email, Pword) VALUES (?,?,?,?)" ;
//		int results = jdbcTemplate.update(sql,"Jean", "Redfearn", "Jred@gmail.com" , "J123");
//		if (results>0) {
//			System.out.println("A new row has been inserted");
//			
//			
//	}
	}
	



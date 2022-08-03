package com.SoulCode.Services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableCaching
@SpringBootApplication
public class ServicesApplication {

	public static void main(String[] args) {

		SpringApplication.run(ServicesApplication.class, args);
		//System.out.println(new BCryptPasswordEncoder().encode("batata"));
		//System.out.println(new BCryptPasswordEncoder().encode("tomate"));
		//System.out.println(new BCryptPasswordEncoder().encode("tangerina"));



	}


}

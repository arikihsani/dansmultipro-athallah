package com.dansmultipro.athallahrikza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class AthallahrikzaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AthallahrikzaApplication.class, args);
	}

}

package com.atlantis;

import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class AtlantisApplication {

	public static void main(String[] args) throws SQLException {

		SpringApplication.run(AtlantisApplication.class, args);

	}

    @Bean
    WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/*").allowedOrigins("*").allowedMethods("*").allowedHeaders("*").exposedHeaders("Authorization");
                System.out.println("Applicazione in avvio...");
            }
        };
    }

}

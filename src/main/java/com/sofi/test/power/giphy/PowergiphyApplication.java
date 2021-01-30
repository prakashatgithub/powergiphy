package com.sofi.test.power.giphy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

/**
 * Main entry point to the application. Salient features of this APIs:
 * 
 * >>>>>>>>>>> Swagger integration (http://localhost:8080/swagger-ui.html#)
 * >>>>>>>>>>> Caching
 * >>>>>>>>>>> API Versioning (/api/v1/search)
 * >>>>>>>>>>> Enhanced Error Control 
 * 
 * 
 * @author psathiyamoorthy
 */
@SpringBootApplication
@EnableCaching
@EnableScheduling
public class PowergiphyApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(PowergiphyApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		
		return new RestTemplate();
	}
}

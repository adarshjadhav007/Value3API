package com.adarsh.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan(basePackages = "com.adarsh")
public class Value3ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(Value3ApiApplication.class, args);
	}
   @Bean
   public RestTemplate getRestTemplate() {
      return new RestTemplate();
   }
}

package com.seong.foodmate.foodmate;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// @MapperScan
@SpringBootApplication
public class FoodmateApplication {	
	public static void main(String[] args) {
		SpringApplication.run(FoodmateApplication.class, args);
	}
}

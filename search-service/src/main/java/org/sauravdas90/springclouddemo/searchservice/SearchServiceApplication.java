package org.sauravdas90.springclouddemo.searchservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class SearchServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SearchServiceApplication.class, args);
	}


	@GetMapping("/searchtest")
	public String testConnection(){
		return "Test Url for Search Service";
	}
}

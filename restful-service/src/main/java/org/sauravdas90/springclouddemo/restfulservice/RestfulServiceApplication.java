package org.sauravdas90.springclouddemo.restfulservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class RestfulServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulServiceApplication.class, args);
	}

	@GetMapping("/resttest")
	public String testConnection(){
		return "Test Url for RestFul Service";
	}

}

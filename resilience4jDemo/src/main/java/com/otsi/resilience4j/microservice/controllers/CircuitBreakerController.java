package com.otsi.resilience4j.microservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


@RestController
@RequestMapping("/circuitbreak")
public class CircuitBreakerController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${greetUserURL}")
	private String greetUserURL;
	
	@GetMapping(path = "/test")
	@CircuitBreaker(name="CircuitBreakerService", fallbackMethod = "testFallBackMethod")
	public String testCircuitBreaker(@RequestParam("username") String username) {
		System.out.println("From circuitbreaker, username: " + username + "\n");
		StringBuilder url = new StringBuilder(greetUserURL + "username=" + username);
		System.out.println("url: " + url);
	    String result = null;
		result = restTemplate.getForObject(url.toString(), String.class);
//		return new ResponseEntity<>(result, HttpStatus.OK);
		return result;
	}
	
	public String testFallBackMethod(Exception ex){
		return "greetUser Service is down. Exception: " + ex.getMessage();
//		return new ResponseEntity<String>("greetUser Service is down", HttpStatus.OK);
	}
}

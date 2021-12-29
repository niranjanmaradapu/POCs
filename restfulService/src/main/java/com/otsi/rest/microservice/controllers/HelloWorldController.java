package com.otsi.rest.microservice.controllers;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/greet")
public class HelloWorldController {
	
	
//	@GetMapping(path = "/user/{username}")
	@GetMapping(path = "/user")
//	@RequestParam(value = “username”) String username
	public String greet(@RequestParam("username") String username) {
		System.out.println("Helloworld \n username: " + username + "\n");
		if(Optional.of(username).isPresent())
			return "Hello " + username;
		
		return "Hello Guest";
	}
}

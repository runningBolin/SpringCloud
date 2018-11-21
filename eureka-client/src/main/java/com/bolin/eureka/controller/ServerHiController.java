package com.bolin.eureka.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerHiController {

	@Value("${server.port}")
	String port;
	
	@RequestMapping("/hi")
	public String home(@RequestParam(value="name", defaultValue="bolin") String name) {
		return "Hi "+ name + ", I am from port:"+ port; 
	}
}

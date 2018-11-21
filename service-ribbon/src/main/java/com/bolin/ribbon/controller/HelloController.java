package com.bolin.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bolin.ribbon.service.HelloService;

@RestController
public class HelloController {

	@Autowired
	HelloService helloService;
	
	@GetMapping(value="/hi")
	public String hi(@RequestParam(value="name") String name) {
		return helloService.hiService(name);
	}
}

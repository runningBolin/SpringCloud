package com.bolin.feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bolin.feign.service.HiService;

@RestController
public class HiController {
	
	@Autowired
	HiService hiService;
	
	@RequestMapping(value="/hi", method=RequestMethod.GET)
	public String sayHi(@RequestParam String name) {
		return hiService.sayHi(name);
	}

}

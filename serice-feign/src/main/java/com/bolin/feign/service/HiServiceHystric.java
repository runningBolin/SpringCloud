package com.bolin.feign.service;

import org.springframework.stereotype.Component;

@Component
public class HiServiceHystric implements HiService {

	@Override
	public String sayHi(String name) {
		return "hi "+ name + ", sorry error. Message from feign.";
	}

}

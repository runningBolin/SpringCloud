package com.bolin.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value="eureka-client")//声明调用服务
public interface HiService {

	@RequestMapping(method=RequestMethod.GET, value="/hi")
	String sayHi(@RequestParam String name);
}

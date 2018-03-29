package com.xpj.controller;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xpj.domain.model.Greeting;

@RestController
@RequestMapping(value = "/restful", method = { RequestMethod.GET, RequestMethod.POST })
public class RestfulWebServiceController {

	private final AtomicInteger counter = new AtomicInteger();

	@Value("${template}")
	private String template;

	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

}

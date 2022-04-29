package com.example.sagasample.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class TestController {
	@RequestMapping(value = "/helloworld", method = RequestMethod.GET, produces = "application/json")
	public String helloworld() {
		return "Hello World";
	}
}

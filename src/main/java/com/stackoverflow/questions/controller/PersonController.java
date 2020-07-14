package com.stackoverflow.questions.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackoverflow.questions.service.PersonService;

@RestController
@RequestMapping("/api/v1")
public class PersonController {
	@Autowired
	private PersonService service;
	
	@GetMapping(value = "/people")
	public List<?> getPerson(){
		return service.findAll();
	}

}

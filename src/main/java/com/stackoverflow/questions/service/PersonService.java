package com.stackoverflow.questions.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackoverflow.questions.model.Person;
import com.stackoverflow.questions.repository.IPersonRepository;

@Service
public class PersonService {

	@Autowired
	private IPersonRepository personRepository;

	public List<Person> findAll() {

		Iterable<Person> results = personRepository.findAll();

		return StreamSupport.stream(results.spliterator(), false).collect(Collectors.toList());
	}
}

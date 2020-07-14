package com.stackoverflow.questions.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackoverflow.questions.model.Person;

@Repository
public interface IPersonRepository extends CrudRepository<Person, Long> {

}

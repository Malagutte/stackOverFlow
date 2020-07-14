package com.stackoverflow.questions.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackoverflow.questions.model.Task;
import com.stackoverflow.questions.repository.ITaskRepository;


@Service
public class TaskService {
	@Autowired
	private ITaskRepository repository;

	public Optional<Task> findById(Long id) {
		return repository.findById(id);
	}

	public void save(Task task) {
		repository.save(task);
	}
}
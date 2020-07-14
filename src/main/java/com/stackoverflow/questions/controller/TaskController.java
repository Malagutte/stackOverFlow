package com.stackoverflow.questions.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackoverflow.questions.dto.TaskDTO;
import com.stackoverflow.questions.model.Message;
import com.stackoverflow.questions.model.Task;
import com.stackoverflow.questions.service.TaskService;



@RestController
@RequestMapping("/")
public class TaskController {
	@Autowired
	private TaskService service;
	
	@PutMapping(value = "/task/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> putTask(@RequestBody TaskDTO request, @PathVariable(name = "id",required = true) Long id) {
		Optional<Task> optional = service.findById(id);
		
		if(!optional.isPresent()) {
			Message msg = new Message();
			msg.setMessage("Cannot find task with given id");
			msg.setStatus(404);
			return ResponseEntity.status(404).body(msg);
		}
		if(request.getDescription() == null || request.getDescription().equals("")) {
			Message msg = new Message();
			msg.setMessage("Task description is required");
			msg.setStatus(400);
			return ResponseEntity.status(400).body(msg);
		}
		optional.get().setDescription(request.getDescription());
		optional.get().setPriority(request.getPriority());
	
		service.save(optional.get());
		return ResponseEntity.ok(request);
	}
}

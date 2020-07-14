package com.stackoverflow.questions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackoverflow.questions.model.Task;

@Repository
public interface ITaskRepository extends JpaRepository<Task, Long> {

}

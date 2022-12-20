package com.ticktask.springboot.webapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import com.ticktask.springboot.webapp.entity.Task;

//mapping the model Task and the data table
public interface TaskRepository extends JpaRepository<Task, Integer> {
	public List<Task> findByUsername(String username);
}

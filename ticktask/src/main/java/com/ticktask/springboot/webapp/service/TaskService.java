package com.ticktask.springboot.webapp.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.ticktask.springboot.webapp.entity.Task;

import jakarta.validation.Valid;

@Service
public class TaskService {
	
	private static List<Task> tasks = new ArrayList<>();
	
	private static int tasksCount = 0;
	
	static {
		
		tasks.add(new Task(++tasksCount, "username", "Karto", "Call John1" , LocalDate.now().plusYears(1), false));
		tasks.add(new Task(++tasksCount, "username ", "ILV", "email Mary1" , LocalDate.now().plusYears(2), false));
		tasks.add(new Task(++tasksCount,"username ", "EIE", "update salesforce1" , LocalDate.now().plusYears(3), false));
	}
	
	public List<Task> findByUsername(String username){
		Predicate<? super Task> predicate= task -> task.getUsername().equalsIgnoreCase(username);
		
		return tasks.stream().filter(predicate).toList();
	}
	
	public void addTask(String username, String projectName, String description, LocalDate deadline, boolean completed) {
	Task task = new Task(++tasksCount,username, projectName,description,deadline,completed);
	tasks.add(task);
	}
	
	public void deleteById(int id) {
		
		Predicate<? super Task> predicate= task -> task.getId() == id;
		tasks.removeIf(predicate);
	}

	public Task findById(int id) {
		Predicate<? super Task> predicate= task -> task.getId() == id;
		Task task = tasks.stream().filter(predicate).findFirst().get();
		return task;
	}

	public void updateTask(@Valid Task task) {
		deleteById(task.getId());
		tasks.add(task);
		
	}

}

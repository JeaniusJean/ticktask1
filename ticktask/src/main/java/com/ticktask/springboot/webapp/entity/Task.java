package com.ticktask.springboot.webapp.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity 
public class Task {
	
	public Task() {
		
	}
	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String username;
	private String projectName;
	private String description;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate deadline;
	private boolean completed;
	
	
	public Task(int id, String username, String projectName, String description, LocalDate deadline, boolean completed) {
		super();
		this.id = id;
		this.username = username;
		this.projectName = projectName;
		this.description = description;
		this.deadline = deadline;
		this.completed = completed;
		
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDeadline() {
		return deadline;
	}

	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", username=" + username + ", projectName=" + projectName + ", description="
				+ description + ", deadline=" + deadline + ", completed=" + completed + "]";
	}

	

}
